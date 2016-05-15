'use strict';

/**
 * @ngdoc overview
 * @name desappGroupdFrontendApp
 * @description
 * # desappGroupdFrontendApp
 *
 * Main module of the application.
 */
var desappGroupdFrontendApp =
  angular
    .module('desappGroupdFrontendApp', [
      'ngAnimate',
      'ngCookies',
      'ngResource',
      'ngRoute',
      'ngSanitize',
      'ngTouch'
    ])

desappGroupdFrontendApp.controller('UserController', function ($scope, $http) {
    $scope.info = {'name': 'jhon',
                    'myScore': 8};



    $scope.myRoutes = [{'startingPoint': 'Berzategui',
                        'endingPoint': 'Quilmes',
                        'routine': { 'startingDate': '15/05/2016',
                                    'endDate': '15/06/2015',
                                    'daysOfWeek': ['Lunes','Martes']}},
                        { 'startingPoint': 'Quilmes',
                          'endingPoint' : 'Plaza de mayo',
                          'routine' : { 'startingDate': '18/05/2016',
                                        'endDate': '9/06/2015',
                                        'daysOfWeek': ['Vieres','Sabados']}}];

   
})
