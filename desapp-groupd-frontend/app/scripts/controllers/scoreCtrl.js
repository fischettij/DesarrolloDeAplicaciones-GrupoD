'use strict';

angular.module('desappGroupdFrontendApp')
.controller('score_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, baseUrl) {

    $scope.user = $cookies.get('user');
    $scope.products = [];
    $scope.showProductSuccess = false;
    $scope.showProductError = false;
    $scope.selectedProduct = null;


    // Paginacion
    $scope.amountPages = 0;
    $scope.page = 0;

    $scope.howMuchProductsRest = function(){
      $http.get( baseUrl + '/products/howMuchProducts').success(function(result) {
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

    $scope.howMuchProducts = function(){
      return Array.apply(null, {length: $scope.amountPages +1}).map(Number.call, Number);
    }

    $scope.productsPrevious = function(){
      $scope.updateProducts($scope.page -1);
    }

    $scope.productsNext = function(){
      $scope.updateProducts($scope.page +1);
    }
    // Fin Paginacion

    $scope.updateProducts = function(page){
      $scope.page = page;
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
      $scope.howMuchProductsRest();
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
    }

    $scope.init();

  } ]);
