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

 desappGroupdFrontendApp.filter('lookForManager',function(){
  return function(manager, managers){
    for (var i = 0; i < managers.length; i++) {
      if (managers[i].manager == manager) {
        return managers[i];
      }
    }
  }
})

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
    MENU: "Menu",
    SIGN_OUT: "Desloguearse",
    PERSONAL_SCORE: "Mi Puntuación",
    Dashboard: 'Pizarra',
    VehicleManager: 'Vehiculos',
    CommentManager: 'Comentarios',
    RouteManager: 'Rutas',
    InscriptionManager: 'Inscripciones',
    ScoreManager: 'Puntaje',
    ACTIONS: 'Acciones',
    ADD_VEHICLE: 'Agregar Vehiculo',
    MODEL: 'Modelo',
    MAX_NUMBER_PASSANGER: 'Maximo de pasajeros',
    REGISTRATION_NUMBER: 'Patente',
    CANCEL: 'Cancelar',
    ACCEPT: 'Aceptar',
    VEHICLE_ERROR: 'El Vehiculo ya se encuentra registrado',
    VEHICLE_SUCCESS: 'El Vehiculo se agrego correctamente',
    VEHICLES: 'Vehiculos',
    ROUTE_ERROR: 'La ruta ya se encuentra registrada',
    ROUTE_SUCCESS: 'La ruta se agrego correctamente',
    MY_ROUTES: 'Mis Rutas',
    ADD_ROUTE: 'Agregar Ruta',
    SEND_MESSAGE: 'Enviar Mensaje'
    
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
  MENU: "Menu",
  SIGN_OUT: "Sign Out",
  PERSONAL_SCORE: "My Score",
  Dashboard: 'Dashboard',
  VehicleManager: 'Vehicles',
  CommentManager: 'Comments',
  RouteManager: 'Routes',
  InscriptionManager: 'Inscriptions',
  ScoreManager: 'Score',
  SEND_MESSAGE: 'Send Message'
});

$translateProvider.preferredLanguage('es');
}]);
