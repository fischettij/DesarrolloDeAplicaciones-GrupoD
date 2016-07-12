'use strict';

angular.module('desappGroupdFrontendApp')
.controller('product_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, baseUrl) {

    $scope.user = $cookies.get('user');
    $scope.listOfProducts = [];
    $scope.showProductSuccess = false;
    $scope.showProductError = false;
    $scope.productToUpdate = null;

    // Paginacion
    $scope.amountPages = 0;
    $scope.page = 0;

    $scope.howMuchProductsRest = function(){
      $http.get( baseUrl + '/users/'+ $scope.user +'/howMuchProducts').success(function(result) {
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
      $scope.products($scope.page -1);
    }

    $scope.productsNext = function(){
      $scope.products($scope.page +1);
    }

    // Fin Paginacion


    $scope.products = function(page){
      $scope.page = page;
      $http.get( baseUrl + '/users/'+ $scope.user + '/products/' + page).success(function(result) {
        $scope.listOfProducts = result;
      })
    };

    $scope.createProduct = function(newProduct){
      $http.post( baseUrl + '/users/'+ $scope.user + '/newproduct', {
        description : newProduct.description,
        requiredPoints : newProduct.requiredPoints,
        stock : newProduct.stock
      }).success(function() {
        $scope.showProductSuccess = true;
        $scope.products(0);
        $scope.howMuchProductsRest();
      }).error(function() {
        $scope.showProductError = true;
      })
    };

    $scope.removeProduct = function(product){
          $http.post( baseUrl + '/users/'+ $scope.user + '/removeproduct', {
            id : product.id,
            description : product.description,
            requiredPoints : product.requiredPoints,
            stock : product.stock
          }).success(function() {
            $scope.showProductSuccess = true;
            $scope.products(0);
            $scope.howMuchProductsRest();
          }).error(function() {
            $scope.showProductError = true;
          })
    };

    $scope.updateProduct = function(product){
      $http.post( baseUrl + '/products/update/'+ product.id , {
        requestedBy : $scope.user,
        requestObject: {id: product.id,
                        description : product.description,
                        requiredPoints : product.requiredPoints,
                        stock : product.stock}
      }).success(function() {
        $scope.showProductSuccess = true;
        $scope.products(0);
      $scope.howMuchProductsRest();
      }).error(function() {
        $scope.showProductError = true;
        $scope.products(0);
        $scope.howMuchProductsRest();
      })      
    }

    $scope.getProducts = function(){
      return $scope.listOfProducts;
    };    

    $scope.initProducts = function(){
      $scope.products(0);
      $scope.howMuchProductsRest();
    };
    
    $scope.setProductToUpdate = function(product){
      $scope.productToUpdate = product;
    }

    $scope.initProducts();

  } ]);
