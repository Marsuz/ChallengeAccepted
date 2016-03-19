/**
 * Created by Marcin on 18.03.2016.
 */

var app = angular.module('challengeAccepted', ['ui.router']);

app.config(function ($urlRouterProvider, $stateProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider.state('home', {
        url: '/',
        templateUrl: 'assets/app/home/home.html'
    })
        .state('about', {
            url: '/about',
            templateUrl: 'assets/app/about/about.html',
        })

        .state('my-challenges', {
            url: '/my-challenges',
            templateUrl: 'assets/app/challenge/my-challenges.html',

        });



});
