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
    LOGIN_ERROR: 'Usuario o Contraseña incorrectos',
    Dashboard: 'Pizarra',
    VehicleManager: 'Vehiculos',
    CommentManager: 'Comentarios',
    RouteManager: 'Rutas',
    InscriptionManager: 'Inscripciones',
    ScoreManager: 'Puntaje'
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
    LOGIN_ERROR: 'Invalid login or password.',
    Dashboard: 'Dashboard',
    VehicleManager: 'Vehicles',
    CommentManager: 'Comments',
    RouteManager: 'Routes',
    InscriptionManager: 'Inscriptions',
    ScoreManager: 'Score'
  });
  
  $translateProvider.preferredLanguage('es');
}]);
