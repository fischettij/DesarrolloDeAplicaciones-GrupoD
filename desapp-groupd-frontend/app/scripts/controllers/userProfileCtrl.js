'use strict';

angular.module('desappGroupdFrontendApp')
.controller('user_profile', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', '$translate','utils', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, $translate,utils, baseUrl) {

  $scope.logedUser = $cookies.get('user');
  $scope.userProfile;

  $scope.requestUserProfile = function(){
    var userProfileId = $cookies.get('userProfileId');
    $cookies.remove('userProfileId');

    $http.get( baseUrl + '/users/profile/'+ userProfileId).success(function(result) { 
      $scope.userProfile = result;
      $scope.userProfile.id = userProfileId;
    })
  }

  $scope.init = function(){
    $scope.userProfile = $scope.requestUserProfile()
  };

  $scope.rateUser = function(commentedPoint){
    var comment;
    if (commentedPoint.comment === undefined){comment = ""}else{comment = commentedPoint.comment};

    $http.post( baseUrl + '/users/' + $scope.logedUser + '/rateUser', {
        commentedUser : $scope.userProfile.id,
        isNegative : commentedPoint.isNegative,
        comment : comment
    }).success(function(){
      
    })
  }

  $scope.init();


} ]);



