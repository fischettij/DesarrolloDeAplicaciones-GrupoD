'use strict';

angular.module('desappGroupdFrontendApp')
.controller('user_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', '$translate','utils', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, $translate,utils, baseUrl) {

  $scope.user = {managers:[]};
  $scope.searchUserContent = '';
  $scope.foundUsers = [];
  $scope.utils = utils;
  $scope.commentedPoints;
  $scope.comments;

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
    $scope.updateCommentedPoints(userID);
    $scope.updateComments(userID);
  };

  $scope.signOut = function(){
    $cookies.remove('user')
    $window.location.href='/'
  };

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

  $scope.getContainer = function(){
    //return 'views/' + $scope.activeManager +'.html';
    return ;
  };

  $scope.getScore = function(){
    return $filter('lookForManager')('ScoreManager', $scope.user.managers).score;                  
  };

  $scope.searchUser = function(serchName){
    $scope.searchUserContent = '';
    $scope.findUsersLike(serchName);
    $scope.goTo('searchUser');
  };

  $scope.findUsersLike = function(userName){
    $http.get(baseUrl + '/users/like/' + userName).success(function(userList){
      $scope.foundUsers = userList;
      console.log(userList);
    }).error(function(){
      $window.location.href = '/404.html';
    });
  };

  $scope.getCommentedPoints = function(){
    return $scope.commentedPoints;
  }

  $scope.iconForCommentedPoint = function(commentedPoint){
    if (commentedPoint.isNegative){
      return 'fa fa-thumbs-o-down negativeComment';
    }else{
      return 'fa fa-thumbs-o-up positiveComment';
    }
  };
  
  $scope.getComments = function(){
    return $scope.comments;
  }

  $scope.updateCommentedPoints = function(userID){
    console.log(userID);
    $http.get( baseUrl + '/users/'+ userID+ '/commentedPoints/1').success(function(result) { 
      $scope.commentedPoints = result;      
    })
  }

  $scope.updateComments = function(userID){
    $http.get( baseUrl + '/users/'+ userID + '/comments/1').success(function(result) { 
      $scope.comments = result;      
    }) 
  }

  $scope.init();
  $scope.selectLanguage(); 

} ]);
