'use strict';

angular.module('desappGroupdFrontendApp')
.controller('vehicle_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter' , 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, baseUrl) {

    $scope.user = $cookies.get('user');
    $scope.listOfVehicles = [];

    $scope.showVehicleSuccess = false;
    $scope.showVehicleError = false;
    $scope.amountPages = 0;
    $scope.page = 0;

    $scope.vehicles = function(page){
      $scope.page = page;
      $http.get( baseUrl + '/users/'+ $scope.user + '/vehicles/' + page).success(function(result) {
        $scope.listOfVehicles = result;
      })
    };

    $scope.howMuchVehiclesRest = function(){
      $http.get( baseUrl + '/users/'+ $scope.user + '/howMuchVehicles').success(function(result) {
        $scope.amountPages = result;
      })
    };

    $scope.getPage = function(){
      return scope.page;
    }

    $scope.pageIs = function(number){
      return number === $scope.page;
    }

    $scope.pageIsMax = function(){
      return $scope.amountPages === $scope.page;
    }

    $scope.createVehicle = function(newVehicle){
      $http.post( baseUrl + '/users/'+ $scope.user + '/newvehicle', {
        model : newVehicle.model,
        maxNumberPassangers : newVehicle.maxNumberPassanger,
        registrationNumber : newVehicle.registrationNumber
      }).success(function() {
        $scope.showVehicleSuccess = true;
        $scope.vehicles(0);
        $scope.howMuchVehiclesRest();
      }).error(function() {
        $scope.showVehicleError = true;
      })
    };

    $scope.getVehicles = function(){
      return $scope.listOfVehicles;
    };

    $scope.initVehicle = function(){
      $scope.howMuchVehiclesRest();
      $scope.vehicles(0);
    };

    $scope.howMuchVehicles = function(){
      return Array.apply(null, {length: $scope.amountPages +1}).map(Number.call, Number);
    }

    $scope.vehiclesPrevious = function(){
      $scope.vehicles($scope.page -1);
    }

    $scope.vehiclesNext = function(){
      $scope.vehicles($scope.page +1);
    }

    $scope.initVehicle();

  } ]);
