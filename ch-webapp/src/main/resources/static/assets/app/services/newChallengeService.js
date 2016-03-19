/**
 * Created by Sara on 2016-03-19.
 */

app.factory('NewChallengeService',function ($resource) {
    return $resource('/challenges',{},{
        addNewChallenge: {
            method: 'POST',
            url: '/challenges/add',
            params: {name: '@name', user: '@user'}
        }
    })
})