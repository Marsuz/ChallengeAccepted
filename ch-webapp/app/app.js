/**
 * Created by Marcin on 18.03.2016.
 */

var app = angular.module('challengeAccepted', ['ui.router', 'ngResource']);

var currUser = {nick: "login"};

app.config(function ($urlRouterProvider, $stateProvider) {
    $urlRouterProvider.otherwise('/');
    $stateProvider.state('home', {
        url: '/',
        templateUrl: 'app/home/home.html',
        controller: function ($rootScope) {
            $rootScope.variable = currUser.nick;
        }
    })
        .state('about', {
            url: '/about',
            templateUrl: 'app/about/about.html',
            controller: 'AboutController'
        })

        .state('my-challenges', {
            url: '/my-challenges',
            templateUrl: 'app/challenge/my-challenges.html',
            controller: function ($scope, Challenges) {
                console.log(Challenges);
                Challenges.add(
                    {
                        id: 1,
                        name: "lalaalal",
                        owner: 'Zajda',
                        expirationdate: '2016-03-22',
                        image: 'small_cup.png',
                        participants: [
                            {
                                id: 1,
                                name: 'Shimmy'
                            }
                        ],
                        invited: [
                            {
                                id: 1,
                                name: 'Zajda'
                            }
                        ]
                    }
                );
                $scope.newchallenges = Challenges.db.newchallenges;
                $scope.acceptedchallenges = Challenges.db.acceptedchallenges;
                $scope.rejectedchallenges = Challenges.db.rejectedchallenges;
                $scope.finishedchallenges = Challenges.db.finishedchallenges;
            }
        })
        .state('challenge-info', {
            url: '/challenge-info',
            templateUrl: 'app/challenge/challenge-info.html',
            controller: function () {
                console.log(currUser);
            }
        })

        .state('users', {
            url: '/users',
            templateUrl: 'app/about/users.html'
        })

        .state('new-challenge', {
            url: '/new-challenge',
            templateUrl: 'app/challenge/new.html',
            controller: function($scope, NewChallengeService){
                $scope.newEntry = {
                    name: "",
                    user: currUser
                };
                $scope.addNewChallenge = function () {
                    console.log( $scope.newEntry);
                    NewChallengeService.addNewChallenge({name: $scope.newEntry.name, user: $scope.newEntry.user})
                }
            }
        })
    
        .state('login', {
            url: '/login',
            templateUrl: 'app/authorization/login.html',
            controller: function ($scope, AuthService, $rootScope) {
                $scope.credentials = {
                    username: "", 
                    password: ""
                };
                $scope.signIn = function () {
                    console.log( $scope.credentials);
                    AuthService.logIn({username : $scope.credentials.username, password: $scope.credentials.password}).$promise.then(function (res) {
                        currUser = res.nick;
                        $rootScope.variable = res.nick;
                        console.log($rootScope.variable);
                    })
                }

            }
        })


    
        .state('register', {
            url: '/register',
            templateUrl: 'app/authorization/register.html',
            controller: function ($scope, AuthService) {
                $scope.credentials = {
                    username: "",
                    name: "",
                    surname: "",
                    password: ""
                };
                $scope.signUp = function () {
                    console.log( $scope.credentials);
                    AuthService.signUp({username : $scope.credentials.username, name: $scope.credentials.name, surname: $scope.credentials.surname, password: $scope.credentials.password})
                    alert("Registered!");
                };
            }
        });


});
