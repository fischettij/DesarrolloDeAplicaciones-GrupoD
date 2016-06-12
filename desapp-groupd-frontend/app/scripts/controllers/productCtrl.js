'use strict';

angular.module('desappGroupdFrontendApp')
.controller('product_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', function($http, $scope, $window, $cookies, $locale, $filter) {

    $scope.baseUrl = "http://localhost:8080/desapp-groupd-backend/rest";
    $scope.user = $cookies.get('user');
    $scope.showProductSuccess = false;
    $scope.showProductError = false;

    $scope.createProduct = function(newProduct){
      $http.post( $scope.baseUrl + '/users/'+ $scope.user + '/newproduct', {
        description : newProduct.description,
        requiredPoints : newProduct.requiredPoints,
        stock : newProduct.stock
      }).success(function() {
        $scope.showProductSuccess = true;
      }).error(function() {
        $scope.showProductError = true;
      })
    };
    
  } ]);
