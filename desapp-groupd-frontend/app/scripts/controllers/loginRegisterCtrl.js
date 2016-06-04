'use strict';

angular.module('desappGroupdFrontendApp')
.controller('main_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', function($http, $scope, $window, $cookies, $locale) {

    $scope.baseUrl = "http://localhost:8080/desapp-groupd-backend/rest";

        // Register

        $scope.showERegisterError = false;
        $scope.showERegisterSuccess = false;
        $scope.registerUser = {};

        $scope.register = function(user) {
          $http.post( $scope.baseUrl + '/register/newuser', {
            name : user.name,
            email : user.email,
            password : user.password
          }).success(function() {
            $scope.showERegisterSuccess = true;
            $scope.clearRegisterUserForm();
          }).error(function() {
            $scope.showERegisterError = true;
          })
        };

        $scope.clearRegisterUserForm = function() {
          $scope.registerUser = {};
        }

        // Login

        $scope.showLoginError = false;

        $scope.login = function(user) {
          $http.post( $scope.baseUrl + '/login/connect', {
            email : user.email,
            password : user.password,
            name : ""
          }).success(function(result) {
            $cookies.put('user',result.id);
            $scope.goToMain();
          }).error(function() {
            $scope.showLoginError = true;
          })
        };

        $scope.goToMain = function() {
          $window.location.href = '/main.html';
        }

      } ]);