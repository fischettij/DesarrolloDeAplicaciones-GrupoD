'use strict';

angular.module('desappGroupdFrontendApp')
.controller('user_profile', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', '$translate','utils', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, $translate,utils, baseUrl) {

  $scope.userProfile;

  $scope.requestUserProfile = function(){
    var userProfileId = $cookies.get('userProfileId');
    $cookies.remove('userProfileId');

    $http.get( baseUrl + '/users/profile/'+ userProfileId).success(function(result) { 
      $scope.userProfile = result;
    })
  }

  $scope.init = function(){
    $scope.userProfile = $scope.requestUserProfile()
  };

  $scope.init();


} ]);
