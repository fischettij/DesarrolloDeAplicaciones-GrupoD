'use strict';

/**
 * @ngdoc overview
 * @name desappGroupdFrontendApp
 * @description
 * # desappGroupdFrontendApp
 *
 * Main module of the application.
 */
var desappGroupdFrontendApp = angular.module('desappGroupdFrontendApp', [
      'ngAnimate',
      'ngCookies',
      'ngResource',
      'ngRoute',
      'ngSanitize',
      'ngTouch',
      'pascalprecht.translate'
    ]);

desappGroupdFrontendApp.config(['$translateProvider', function ($translateProvider) {
  
  $translateProvider.useSanitizeValueStrategy(null);

  $translateProvider.translations('es', {
    LOGIN_DESCRIPTION: 'Iniciar sesión para empezar',
    PASSWORD: 'Contraseña',
    EMAIL: 'Correo',
    FULL_NAME: 'Nombre Completo',
    SIGN_IN_GOOGLE: 'Entra con Google+',
    SIGN_IN:'Entrar',
    REGISTER_DESCRIPTION: 'Registrar nuevo usuario',
    REGISTER: 'Registrar',
    REGISTER_ERROR: 'Usuario en uso',
    REGISTER_SUCCESS: 'Cuenta creada!',
    LOGIN_ERROR: 'Usuario o Contraseña incorrectos'
  });

  $translateProvider.translations('en', {
    LOGINDESCRIPTION: 'Sign in to start your session',
    PASSWORD: 'Password',
    EMAIL: 'Email',
    FULL_NAME: 'Full Name',
    SIGN_IN_GOOGLE: 'Sign in using Google+',
    SIGN_IN:'Sign In',
    REGISTER_DESCRIPTION: 'Register a new membership',
    REGISTER: 'Register',
    REGISTER_ERROR: 'There were problems creating your account',
    REGISTER_SUCCESS: 'Created successfully!',
    LOGIN_ERROR: 'Invalid login or password.'
  });
  
  $translateProvider.preferredLanguage('es');
}]);

desappGroupdFrontendApp.controller('main_ctrl', [ '$http', '$scope', '$window',
      '$locale', function($http, $scope, $window, $locale) {

        $scope.baseUrl = "http://localhost:8080/desapp-groupd-backend/rest";

        // Register

        $scope.showERegisterError = false;
        $scope.showERegisterSuccess = false;

        $scope.register = function(user) {
          $http.post( $scope.baseUrl + '/register/newuser', {
            name : user.name,
            email : user.email,
            password : user.password
          }).success(function() {
            $scope.showERegisterSuccess = true;
          }).error(function() {
            $scope.showERegisterError = true;
          })
        };

        // Login

        $scope.showLoginError = false;

        $scope.login = function(user) {
          $http.post( $scope.baseUrl + '/login/connect', {
            email : user.email,
            password : user.password,
            name : ""
          }).success(function() {
            $scope.goToMainManu();
          }).error(function() {
            $scope.showLoginError = true;
          })
        };

        $scope.goToMainManu = function() {
          
        }

      } ]);
