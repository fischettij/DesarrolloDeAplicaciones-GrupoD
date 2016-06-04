'use strict';

/**
 * @ngdoc function
 * @name desappGroupdFrontendApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the desappGroupdFrontendApp
 */
 angular.module('desappGroupdFrontendApp')
 .controller('MainCtrl', function () {
 	this.awesomeThings = [
 	'HTML5 Boilerplate',
 	'AngularJS',
 	'Karma'
 	];
 });

 var contentApp = angular.module('contentApp', []);

 contentApp.controller('currentUserCtrl', ['$scope', function($scope) {
 	$scope.userInformation = {'name': Jhon};
 }]);
