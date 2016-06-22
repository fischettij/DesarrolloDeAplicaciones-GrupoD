'use strict';

angular.module('desappGroupdFrontendApp')
.controller('vehicle_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter' , 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, baseUrl) {

    $scope.user = $cookies.get('user');
    $scope.listOfVehicles = [];

    $scope.showVehicleSuccess = false;
    $scope.showVehicleError = false;

    $scope.vehicles = function(page){
      $http.get( baseUrl + '/users/'+ $scope.user + '/vehicles/' + page).success(function(result) {
        $scope.listOfVehicles = result;
      })
    };


    $scope.createVehicle = function(newVehicle){
      $http.post( baseUrl + '/users/'+ $scope.user + '/newvehicle', {
        model : newVehicle.model,
        maxNumberPassangers : newVehicle.maxNumberPassanger,
        registrationNumber : newVehicle.registrationNumber
      }).success(function() {
        $scope.showVehicleSuccess = true;
        $scope.vehicles(1);
      }).error(function() {
        $scope.showVehicleError = true;
      })
    };

    $scope.getVehicles = function(){
      return $scope.listOfVehicles;
    };

    $scope.initVehicle = function(){
      $scope.vehicles(1);
    };

    $scope.initVehicle();

  } ]);
