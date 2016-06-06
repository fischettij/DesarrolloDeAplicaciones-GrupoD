'use strict';

angular.module('desappGroupdFrontendApp')
.controller('route_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', function($http, $scope, $window, $cookies, $locale, $filter) {

    $scope.baseUrl = "http://localhost:8080/desapp-groupd-backend/rest";
    $scope.user = $cookies.get('user');
    $scope.listOfMyRoutes = [];

    $scope.showRouteSuccess = false;
    $scope.showRouteError = false;
//// Start Google maps

  //Create a map and center it on Argentina.
  $scope.mapRegisterRoute = new google.maps.Map(
    document.getElementById('mapRegisterRoute'), {
      zoom: 4,
      center: {lat: -34.603684, lng: -58.3815591}});

  $scope.markerArray = [];
  $scope.directionsService = new google.maps.DirectionsService;
  $scope.directionsDisplay = new google.maps.DirectionsRenderer({mapRegisterRoute: $scope.mapRegisterRoute});
  $scope.stepDisplay = new google.maps.InfoWindow;

  $scope.calculateAndDisplayRoute = function(startingPoint, endingPoint) {
    // First, remove any existing markers from the map.
    for (var i = 0; i < $scope.markerArray.length; i++) {
      $scope.markerArray[i].setMap(null);
    };
    $scope.directionsService.route({
      origin: startingPoint,
      destination: endingPoint,
      travelMode: google.maps.TravelMode.DRIVING}, function(response, status) {
        if (status === google.maps.DirectionsStatus.OK) {
          $scope.directionsDisplay.setMap($scope.mapRegisterRoute);
          $scope.directionsDisplay.setDirections(response);
        } else {
          window.alert('Directions request failed due to ' + status);
        }
      });       
  };

  $("#modalNewRoute").on('shown.bs.modal', function () {
    google.maps.event.trigger($scope.mapRegisterRoute, 'resize');
    $scope.mapRegisterRoute.setCenter({lat: -34.603684, lng: -58.3815591});
  });

///// End - Google Maps

$scope.myRoutes = function(page){
  $http.get( $scope.baseUrl + '/users/'+ $scope.user + '/routes/' + page).success(function(result) {
    $scope.listOfRoutes = result;
  })
};

$scope.createRoute = function(newRoute){
  $http.post( $scope.baseUrl + '/users/'+ $scope.user + '/newroute', {
    startingPoint: newRoute.startingPoint,
    endingPoint: newRoute.endingPoint,
    routine: {
      startingDate: newRoute.startingDate,
      endDate: newRoute.endDate,
      daysOfWeek: newRoute.daysOfWeek,
    },
    subscriptionRequests: []
  }).success(function() {
    $scope.showRouteSuccess = true;
    $scope.routes(1)
  }).error(function() {
    $scope.showRouteError = true;
  })
};

$scope.getMyRoutes = function(){
  return $scope.listOfMyRoutes;
};

$scope.initRoute = function(){
      //$scope.myRoutes(1);
    };

    $scope.initRoute();

  } ]);
