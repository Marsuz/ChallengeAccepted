/**
 * Created by Sara on 2016-03-19.
 */

app.directive("timer", function(){
    return {
        restrict: "E",
        template: "{{time.days}}d {{time.hours}}h {{time.minutes}}m {{time.seconds}}s",
        scope: {
            endTime:'='
        },
        link: function(scope){
            scope.time = {
                total: 0,
                days: 0,
                hours: 0,
                minutes: 0,
                seconds: 0
            };


            function getTimeRemaining(endtime){
                var t = Date.parse(endtime) - Date.parse(new Date());
                var seconds = Math.floor( (t/1000) % 60 );
                var minutes = Math.floor( (t/1000/60) % 60 );
                var hours = Math.floor( (t/(1000*60*60)) % 24 );
                var days = Math.floor( t/(1000*60*60*24) );
                if(seconds>0){
                    return {
                        'total': t,
                        'days': days,
                        'hours': hours,
                        'minutes': minutes,
                        'seconds': seconds
                    };
                }else{
                    return {
                        'total': 0,
                        'days': 0,
                        'hours': 0,
                        'minutes': 0,
                        'seconds': 0
                    };
                }
            }

            var timeinterval = setInterval(function(){
                var t = getTimeRemaining(scope.endTime);
                
                scope.time.days = t.days;
                scope.time.hours = t.hours;
                scope.time.minutes = t.minutes;
                scope.time.seconds = t.seconds;
                scope.$apply();

                
                if(t.total<=0){
                    clearInterval(timeinterval);
                }
            },1000);



        }
    }
}) 