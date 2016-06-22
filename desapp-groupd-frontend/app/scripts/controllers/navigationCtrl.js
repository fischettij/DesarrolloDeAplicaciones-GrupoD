'use strict';

angular.module('desappGroupdFrontendApp')
.controller('navigation_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', '$translate','utils' ,'baseUrl' , function($http, $scope, $window, $cookies, $locale, $filter, $translate,utils,baseUrl) {

  $scope.user = {managers:[]};
  $scope.foundUsers = [];
  $scope.utils = utils;

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

  $scope.init = function(){
    var userID = $cookies.get('user');
    $http.get(baseUrl + '/users/' + userID).success(function(user){
      $scope.user = user;
    }).error(function(){
     $window.location.href = '/404.html';
    });
  };

  $scope.signOut = function(){
    $cookies.remove('user')
    $window.location.href='/'
  };

  $scope.init();
  $scope.selectLanguage(); 

  $scope.activeManager = 'dashboard';

  $scope.managers = function(){
    return $scope.user.managers;
  };

  $scope.handling = function(managerName){
    return $scope.activeManager === managerName;
  };

  $scope.iconFor = function(managerName){
    switch(managerName) {
      case 'VehicleManager':
      return 'fa fa-cab';
      break;
      case 'CommentManager':
      return 'fa fa-comments';
      break;
      case 'RouteManager':
      return 'fa fa-map-marker';
      break;
      case 'InscriptionManager':
      return 'fa fa-edit';
      break;
      case 'ScoreManager':
      return 'fa fa-star-o';
      break;
      case 'AdminManager':
      return 'fa fa-user-plus';
      break;
      case 'ProductManager':
      return 'fa fa-television';
      break;
      default:
      return 'fa fa-warning';
    }
  };

  $scope.getScore = function(){
    return $filter('lookForManager')('ScoreManager', $scope.user.managers).score;                  
  };

  $scope.searchUser = function(serchName){
    $scope.findUsersLike(serchName);
    utils.goTo('searchUser');
  };

  $scope.findUsersLike = function(userName){
    $http.get(baseUrl + '/users/like/' + userName).success(function(userList){
      $scope.foundUsers = userList;
    }).error(function(){
      $window.location.href = '/404.html';
    });
  };

  $scope.goToUser = function(user){
    $cookies.put('userProfileId',user.id);
    utils.goTo('userProfile')
  }

} ]);
