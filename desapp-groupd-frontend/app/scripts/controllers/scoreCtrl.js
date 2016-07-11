'use strict';

angular.module('desappGroupdFrontendApp')
.controller('score_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, baseUrl) {

    $scope.user = $cookies.get('user');
    $scope.products = [];
    $scope.showProductSuccess = false;
    $scope.showProductError = false;
    $scope.selectedProduct = null;

    $scope.updateProducts = function(page){
      $http.get( baseUrl + '/products/all/' + page).success(function(result) {
        $scope.products = result;
      })
    };

    $scope.purchaseProduct = function(product){
      $http.post( baseUrl + '/products/' + product.id + '/purchaseBy/' + $scope.user).success(function() {
        $scope.selectedProduct = product;
        $scope.showProductSuccess = true;
        $('#modalVoucher').modal('show');
        $scope.updateProducts;
      }).error(function() {
        $scope.showProductError = true;
      })
    }

    $scope.getProducts = function(){
      return $scope.products;
    }    

    $scope.init = function(){
      $scope.updateProducts(0);
    };

    $scope.getSelectedProduct = function(){
      return $scope.selectedProduct;
    }

    $scope.printDiv = function(divName){
      var printContents = document.getElementById(divName).innerHTML;
      var originalContents = document.body.innerHTML;

      document.body.innerHTML = printContents;

      window.print();

      document.body.innerHTML = originalContents;
      window.print();
    }

    $scope.init();

  } ]);
