(function() {
	var app = angular.module('desappGroupdFrontendApp');

	app.controller('login_register_ctrl', [ '$http', '$scope', '$window',
			'$locale', function($http, $scope, $window, $locale) {

				$scope.baseUrl = "http://localhost:8080/desapp-groupd-backend/rest/";
				$scope.language = [];

				$scope.init = function() {
					if (navigator.language.slice(0, 2) == "es") {
						$http.get('/spanishJson').success(function(result) {
							$scope.language = result.data;
						});
					} else {
						$http.get('/englishJson').success(function(result) {
							$scope.language = result.data;
						});
					}
				};


				// Register

				$scope.showRegisterEvent = false;
				$scope.eventRegiste = "";

				$scope.register = function(user) {
					$http.post( $scope.baseUrl + '/register/register', {
						username : user.username,
						email : user.email,
						password : user.password
					}).success(function(result) {
						$scope.showRegisterEvent = true;
						$scope.eventRegister = result;
					}).error(function(result) {
						$scope.showRegisterEvent = true;
						$scope.eventRegister = result;
					})
				};

				// Login

				$scope.showLoginError = false;

				$scope.login = function(user) {
					$http.post('/login', {
						email : user.email,
						password : user.password
					}).success(function() {
						$scope.goToMainManu();
					}).error(function() {
						$scope.showLoginError = true;
					})
				};

				$scope.goToMainManu = function() {
					$window.location.href = '/goToMainMenu';
				}

			} ]);
})();