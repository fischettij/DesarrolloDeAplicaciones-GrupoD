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

   
});

desappGroupdFrontendApp.controller('login_register_ctrl', [ '$http', '$scope', '$window',
      '$locale', function($http, $scope, $window, $locale) {

        $scope.baseUrl = "http://localhost:8080/desapp-groupd-backend/rest";
        $scope.language = [];

        $scope.init = function() {
          if (navigator.language.slice(0, 2) == "es") {
            $http.get('/spanishJson').success(function(result) {
              $scope.language = result.data;
            });
          } else {
            $http.get('/englishJson').success(function(result) {
              $scope.language = result.data;
            });
          }
        };


        // Register

        $scope.showRegisterEvent = false;
        $scope.eventRegiste = "";

        $scope.register = function(user) {
          $http.post( $scope.baseUrl + '/register/newuser', {
            name : user.name,
            email : user.email,
            password : user.password
          }).success(function(result) {
            $scope.showRegisterEvent = true;
            $scope.eventRegister = result;
          }).error(function(result) {
            $scope.showRegisterEvent = true;
            $scope.eventRegister = result;
          })
        };

        // Login

        $scope.showLoginError = false;

        $scope.login = function(user) {
          $http.post('/login', {
            email : user.email,
            password : user.password
          }).success(function() {
            $scope.goToMainManu();
          }).error(function() {
            $scope.showLoginError = true;
          })
        };

        $scope.goToMainManu = function() {
          $window.location.href = '/goToMainMenu';
        }

      } ]);
