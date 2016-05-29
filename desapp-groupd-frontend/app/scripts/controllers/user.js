'use strict';

angular.module('desappGroupdFrontendApp')
  .controller('user_ctrl', [ '$http', '$scope', '$window', '$cookies',
      '$locale', function($http, $scope, $window, $cookies, $locale) {

      	 $scope.baseUrl = "http://localhost:8080/desapp-groupd-backend/rest";
      	 $scope.user = {};

      	$scope.init = function(){
      		var userID = $cookies.get('user');
      		$http.get($scope.baseUrl + '/users/' + userID).success(function(user){
      			$scope.user = user;
      		}).error(function(){
      			$window.location.href = '/404.html';
      		}) 
      	};

            $scope.init();

            $scope.activeManager = 'dashboard';

            $scope.managers = function(){
                  return $scope.user.managers;
            };

            $scope.handling = function(managerName){
                  return $scope.activeManager === managerName;
            };

            $scope.goTo = function(managerName){
                  $scope.activeManager = managerName;
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
                              return 'fa fa-comments';
                              break;
                        default:
                              return 'fa fa-warning';
                  }
            };


      } ]);
      