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
  'pascalprecht.translate',
  'checklist-model'
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

desappGroupdFrontendApp.factory('utils',function(){

  var utils = {};
  var activeWindow = 'dashboard'

  utils.getActiveWindow = function(){
    return 'views/' + activeWindow +'.html';
  }

  utils.goTo = function(view){
    activeWindow = view;
  }

  return utils
})

desappGroupdFrontendApp.factory('baseUrl',function(){
  return "http://localhost:8080/desapp-groupd-backend/rest";
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
    SEND_MESSAGE: 'Enviar Mensaje',
    STARTING_POINT:'Desde' ,
    ENDING_POINT:'Hasta',
    STARTING_DATE: 'Desde',
    ENDING_DATE: 'Hasta',
    DAYS_OF_WEEK: 'Días',
    MON: 'Lunes',
    TUE: 'Martes',
    WED: 'Miercoles',
    THU:'Jueves',
    FRI:'Viernes',
    SAT: 'Sabado',
    SUN: 'Domingo',
    SHOW_ROUTE: 'Ver ruta',
    ProductManager: 'Productos',
    ADD_PRODUCT: 'Agregar Producto',
    DESCRIPTION: 'Descripción',
    REQUIRED_POINTS: 'Puntos requeridos',
    STOCK: 'Stock',
    PRODUCTS: 'Productos',
    VEHICLE: 'Vehiculo',
    LOOK: 'Buscar',
    SEARCH_ROUTE: 'Buscar Ruta',
    CLOSE: 'Cerrar',
    ACTION_SUCCESS: 'Acción completada',
    ACTION_ERROR: 'Fallo la acción ',
    OWNER: 'Dueño',
    CANDIDATE: 'Candidato',
    SUBSCRIPTION_STATE: 'Estado de la subscripción',
    Pending: 'Pendiente',
    Accepted: 'Aceptado',
    SCORE: 'Puntuación',
    NEGATIVE: 'Negativo',
    POSITIVE: 'Positivo',
    COMMENT: 'Comentario',
    POINTS: 'Puntos',
    REQUEST_ROUTE: 'Solicitud de inscripción a ruta',
    REQUEST_ROUTE_QUESTION: '¿Esta seguro de enviar la Solicitud?',
    INSCRIPTION_ERROR: 'Error al procesar la inscripción',
    INSCRIPTION_SUCCESS: 'La inscripción se proceso correctamente',
    INSCRIPTIONS: 'Inscripciones',
    INSCRIPTION_STATE: 'Estado de la Inscripción',

  });

$translateProvider.translations('en', {
  LOGIN_DESCRIPTION: 'Sign in to start your session',
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
  ACTIONS: 'Actions',
  ADD_VEHICLE: 'Add Vehicle',
  MODEL: 'Model',
  MAX_NUMBER_PASSANGER: 'Max number of passanger',
  REGISTRATION_NUMBER: 'Registration number',
  CANCEL: 'Cancel',
  ACCEPT: 'Accept',
  VEHICLE_ERROR: 'The vehicle is already registered',
  VEHICLE_SUCCESS: 'The vehicle was successfully added',
  VEHICLES: 'Vehicles',
  ROUTE_ERROR: 'The route is already registered',
  ROUTE_SUCCESS: 'The route was successfully added',
  MY_ROUTES: 'My Routes',
  ADD_ROUTE: 'Add Route',
  SEND_MESSAGE: 'Send Message',
  STARTING_POINT:'From' ,
  ENDING_POINT:'Until',
  STARTING_DATE: 'From',
  ENDING_DATE: 'Until',
  DAYS_OF_WEEK: 'Days',
  MON: 'Monday',
  TUE: 'Tuesday',
  WED: 'Wednesday',
  THU:'Thursday',
  FRI:'Friday',
  SAT: 'Saturday',
  SUN: 'Sunday',
  SHOW_ROUTE: 'Show Route',
  ProductManager: 'Products',
  ADD_PRODUCT: 'Add Product',
  DESCRIPTION: 'Description',
  REQUIRED_POINTS: 'Required points',
  STOCK: 'Stock',
  PRODUCTS: 'Products',
  VEHICLE: 'Vehicle',
  LOOK: 'Look',
  SEARCH_ROUTE: 'Look route',
  CLOSE: 'Close',
  ACTION_SUCCESS: 'Action complete',
  ACTION_ERROR: 'Action Failer',
  OWNER: 'Owner',
  CANDIDATE: 'Candidate',
  SUBSCRIPTION_STATE: 'Subscription State',
  Pending: 'Pending',
  Accepted: 'Accepted',
  SCORE: 'Score',
  NEGATIVE: 'Negative',
  POSITIVE: 'Positive',
  COMMENT: 'Comment',
  POINTS: 'Points',
  REQUEST_ROUTE: 'Request form of Inscription of route' ,
  REQUEST_ROUTE_QUESTION: 'Are you sure you send the request?',
  INSCRIPTION_ERROR: 'Error processing the Inscription',
  INSCRIPTION_SUCCESS: 'The Inscription process correctly',
  INSCRIPTIONS: 'Inscriptions',
  INSCRIPTION_STATE: 'Inscription State',

});

$translateProvider.preferredLanguage('es');

}]);
