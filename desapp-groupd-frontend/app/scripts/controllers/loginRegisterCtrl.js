'use strict';

angular.module('desappGroupdFrontendApp').controller('main_ctrl', [ '$http', '$scope', '$window', '$cookies', 
  '$locale', '$translate' , 'baseUrl', function($http, $scope, $window, $cookies, $locale, $translate,baseUrl) {
  

  // Register

  $scope.showERegisterError = false;
  $scope.showERegisterSuccess = false;
  $scope.registerUser = {};

  $scope.register = function(user) {
    $http.post( baseUrl + '/register/newuser', {
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
    $http.post( baseUrl + '/login/connect', {
      email : user.email,
      password : user.password,
      name : ""
    }).success($scope.loginSuccess).error($scope.loginError);
  };

  $scope.goToMain = function() {
    $window.location.href = '/main.html';
  }

  // Google Login and register

  $scope.auth2 = {};

  $scope.startApp = function() {
    gapi.load('auth2', function(){
      $scope.auth2 = gapi.auth2.init({
        client_id: '694615735422-dkgv5pmv8at39h5i1hqgdh0i10jjb26c.apps.googleusercontent.com',
        cookiepolicy: 'single_host_origin',
      });
      $scope.attachSignin(document.getElementById('gooogleLogin'));
    });
  };

  $scope.attachSignin = function(element) {
    $scope.auth2.attachClickHandler(element, {}, $scope.onLoginSuccess, $scope.onLoginError);      
  }

  $scope.onLoginError = function(error) {
    $scope.loginError();
  };

  $scope.onLoginSuccess = function(googleUser) {
    var profile = googleUser.getBasicProfile();
    $http.post( baseUrl + '/login/googleconnect', {
      email : profile.getEmail(),
      password : "",
      name : profile.getName()
    }).success($scope.loginSuccess).error($scope.loginError);
  };

  $scope.loginSuccess = function(result) {
    $cookies.put('user',result.id);
    $scope.goToMain();
  };

  $scope.loginError = function() {
    $scope.showLoginError = true;
  }

  // Select Language

  $scope.changeLanguage = function (langKey) {
    $translate.use(langKey);
  };

  $scope.selectLanguage = function(){
    if (navigator.language.slice(0, 2) == "es") {
      $scope.changeLanguage("es");
    } else {
      $scope.changeLanguage("en");
    };
  };

  $scope.startApp();
  $scope.selectLanguage();

} ]);