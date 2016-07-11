'use strict';

angular.module('desappGroupdFrontendApp')
.controller('inscription_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, baseUrl) {

    $scope.user = $cookies.get('user');
    $scope.listOfInscriptions = [];
    $scope.showSuccess = false;
    $scope.showError = false;
    $scope.requestInscription = {};

    // Paginación
    $scope.amountPages = 0;
    $scope.page = 0;

    $scope.howMuchInsctiptionRest = function(){
      $http.get( baseUrl + '/users/'+ $scope.user + '/howMuchInscriptions').success(function(result) {
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

    $scope.howMuchInscriptions = function(){
      return Array.apply(null, {length: $scope.amountPages +1}).map(Number.call, Number);
    }

    $scope.inscriptionsPrevious = function(){
      $scope.inscriptions($scope.page -1);
    }

    $scope.inscriptionsNext = function(){
      $scope.inscriptions($scope.page +1);
    }

    $scope.inscriptions = function(page){
      $http.get( baseUrl + '/users/'+ $scope.user + '/inscriptions/' + page).success(function(result) {
        $scope.listOfInscriptions = result;
      })
    };

    $scope.getInscriptions = function() {
    	return $scope.listOfInscriptions;
    };

    $scope.initInscriptions = function(){
      $scope.howMuchInsctiptionRest();
      $scope.inscriptions(0);
    };

    $scope.initInscriptions();

    $scope.request = function(inscriptionIndex){
      $scope.requestInscription = $scope.listOfInscriptions[inscriptionIndex];
    };

    $scope.aceptedRemoveInscription = function(){
      $http.post( baseUrl + '/users/'+ $scope.user + '/removeInscription/' + $scope.requestInscription.id).success(function() {
        $scope.showSuccess = true;
      }).error(function() {
        $scope.showError = true;
      })
    };


  } ]);
