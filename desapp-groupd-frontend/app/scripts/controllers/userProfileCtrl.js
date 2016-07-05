'use strict';

angular.module('desappGroupdFrontendApp')
.controller('user_profile', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', '$translate','utils', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, $translate,utils, baseUrl) {

  $scope.logedUser = $cookies.get('user');
  $scope.userProfile;
  $scope.userProfileId;
  $scope.commentedPoints;

  $scope.requestUserProfile = function(){

    $http.get( baseUrl + '/users/profile/'+ $scope.userProfileId).success(function(result) { 
      $scope.userProfile = result;
    })
  }

  $scope.requestCommentedPoints = function(){
    $http.get( baseUrl + '/users/'+ $scope.userProfileId + '/commentedPoints/1').success(function(result) { 
      $scope.commentedPoints = result;      
    })
  }

  $scope.updateCommentedPoints = function(){
    $http.get( baseUrl + '/users/'+ $scope.userProfileId + '/commentedPoints/1').success(function(result) { 
      $scope.commentedPoints = result;      
    })
  }

  $scope.updateComments = function(){
    $http.get( baseUrl + '/users/'+ $scope.userProfileId + '/comments/1').success(function(result) { 
      $scope.comments = result;      
    }) 
  }

  $scope.init = function(){
    $scope.userProfileId = $cookies.get('userProfileId');
    $cookies.remove('userProfileId');

    $scope.userProfile = $scope.requestUserProfile();
    $scope.updateCommentedPoints();
    $scope.updateComments();
  };

  $scope.rateUser = function(commentedPoint){
    var comment;
    if (commentedPoint.comment === undefined){comment = ""}else{comment = commentedPoint.comment};

    $http.post( baseUrl + '/users/rate/' + $scope.userProfile.id , {
        userId : $scope.logedUser,
        userName: "",
        isNegative : commentedPoint.isNegative,
        comment : comment
    }).success(function(){
      $scope.updateCommentedPoints();
    })
  }

  $scope.getCommentedPoints = function(){
    return $scope.commentedPoints;
  }

  $scope.iconForCommentedPoint = function(commentedPoint){
    if (commentedPoint.isNegative){
      return 'fa fa-thumbs-o-down';
    }else{
      return 'fa fa-thumbs-o-up';
    }
  };

  $scope.newComment = function(newComment){
    $http.post( baseUrl + '/users/comment/' + $scope.userProfile.id , {
        userId : $scope.logedUser,
        userName: "",
        message: newComment.message,
        date: null,
    }).success(function(){
      $scope.updateComments();
    })
  }

  $scope.getComments = function(){
    return $scope.comments;
  }

  $scope.init();


} ]);



