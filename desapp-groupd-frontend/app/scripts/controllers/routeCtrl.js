'use strict';

angular.module('desappGroupdFrontendApp')
.controller('route_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', function($http, $scope, $window, $cookies, $locale, $filter) {

    $scope.baseUrl = "http://localhost:8080/desapp-groupd-backend/rest";
    $scope.user = $cookies.get('user');
    $scope.listOfRoutes = [];
    $scope.searchResult = [];

    $scope.showRouteSuccess = false;
    $scope.showRouteError = false;

    $scope.daysOfWeek = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];

    $scope.vehicles = [];
  //// Start Google maps

  //Create a map and center it on Argentina.
  $scope.mapRegisterRoute = new google.maps.Map(
    document.getElementById('mapRegisterRoute'), {
      zoom: 4,
      center: {lat: -34.603684, lng: -58.3815591}});

  $scope.mapSearchRoute = new google.maps.Map(
    document.getElementById('mapSearchRoute'), {
      zoom: 4,
      center: {lat: -34.603684, lng: -58.3815591}});

  $scope.markerArray = [];
  $scope.directionsService = new google.maps.DirectionsService;
  $scope.directionsDisplay = new google.maps.DirectionsRenderer({mapRegisterRoute: $scope.mapRegisterRoute});
  $scope.directionsDisplayForSearch = new google.maps.DirectionsRenderer({mapSearchRoute: $scope.mapSearchRoute});
  $scope.stepDisplay = new google.maps.InfoWindow;
  $scope.geocoder = new google.maps.Geocoder();

  $scope.startLocationLat = 0;
  $scope.startLocationLng = 0;
  $scope.endLocationLat = 0;
  $scope.endLocationLng = 0;

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
          $scope.startLocationLat = response.routes[0].legs[0].start_location.lat();
          $scope.startLocationLng = response.routes[0].legs[0].start_location.lng();
          $scope.endLocationLat = response.routes[0].legs[0].end_location.lat();
          $scope.endLocationLng = response.routes[0].legs[0].end_location.lng();
        } else {
          window.alert('Directions request failed due to ' + status);
        }
      });       
  };

  $("#modalNewRoute").on('shown.bs.modal', function () {
    google.maps.event.trigger($scope.mapRegisterRoute, 'resize');
    $scope.mapRegisterRoute.setCenter({lat: -34.603684, lng: -58.3815591});
  });
  // ------------------------------------------

  // $scope.mapForLookingRoutes = new google.maps.Map(
  //   document.getElementById('mapForLookingRoutes'), {
  //     zoom: 4,
  //     center: {lat: -34.603684, lng: -58.3815591}}); 

  // $scope.markerArray2 = [];
  // $scope.directionsService2 = new google.maps.DirectionsService;
  // $scope.directionsDisplay2 = new google.maps.DirectionsRenderer({mapForLookingRoutes: $scope.mapForLookingRoutes});
  // $scope.stepDisplay2 = new google.maps.InfoWindow;

///// End - Google Maps

$scope.myRoutes = function(page){
  $http.get( $scope.baseUrl + '/users/'+ $scope.user + '/routes/' + page).success(function(result) {
    $scope.listOfRoutes = result;
  })
};

$scope.cleanLocations = function(){
  $scope.startLocationLat = 0;
  $scope.startLocationLng = 0;
  $scope.endLocationLat = 0;
  $scope.endLocationLng = 0;
};

$scope.createRoute = function(newRoute){
  $http.post( $scope.baseUrl + '/users/'+ $scope.user + '/newroute', {
    startPoint: newRoute.startingPoint,
    endPoint: newRoute.endingPoint,
    startLatitud: $scope.startLocationLat,
    startLongitud: $scope.startLocationLng,
    endLatitud: $scope.endLocationLat, 
    endLongitud: $scope.endLocationLng,
    daysOfWeek: newRoute.routeDaysOfWeek,
    idVehicle: newRoute.idVehicle,
  }).success(function() {
    $scope.showRouteSuccess = true;
    $scope.myRoutes(1);
    $scope.cleanLocations();
  }).error(function() {
    $scope.showRouteError = true;
  })
};

$scope.getMyRoutes = function(){
  return $scope.listOfRoutes;
};

$scope.myVehicles = function(){
  return $scope.vehicles;
};

$scope.getVehicles = function(){
  $http.get( $scope.baseUrl + '/users/' + $scope.user + '/vehicles/1').success(function(result){
    $scope.vehicles = result;
  });
};

$scope.getSearchResult = function(){
  return $scope.searchResult;
}

$scope.searchForRoute = function(route){
  $scope.directionsService.route({
    origin: route.startingPoint,
    destination: route.endingPoint,
    travelMode: google.maps.TravelMode.DRIVING}, function(response, status) {
      if (status === google.maps.DirectionsStatus.OK) {
        $scope.startLocationLat = response.routes[0].legs[0].start_location.lat();
        $scope.startLocationLng = response.routes[0].legs[0].start_location.lng();
        $scope.endLocationLat = response.routes[0].legs[0].end_location.lat();
        $scope.endLocationLng = response.routes[0].legs[0].end_location.lng();
        $http.post( $scope.baseUrl + '/routes/lookfor', {
          startPoint: route.startingPoint,
          endPoint: route.endingPoint,
          startLatitud: $scope.startLocationLat,
          startLongitud: $scope.startLocationLng,
          endLatitud: $scope.endLocationLat, 
          endLongitud: $scope.endLocationLng,
          daysOfWeek: route.routeDaysOfWeek,
          idVehicle: 0
        }).success(function(result) {
          $scope.searchResult = result;
          $scope.cleanLocations();
        });
      } else {
        window.alert('Directions request failed due to ' + status);
      }
    });

}

$scope.directionForMap = {};
$scope.requestRoute = null;

$scope.openMapModal = function(routeIndex){
  var route = $scope.searchResult[routeIndex];
  // First, remove any existing markers from the map.
  for (var i = 0; i < $scope.markerArray.length; i++) {
    $scope.markerArray[i].setMap(null);
  };
  $scope.directionsService.route({
    origin: route.startPoint,
    destination: route.endPoint,
    travelMode: google.maps.TravelMode.DRIVING}, function(response, status) {
      if (status === google.maps.DirectionsStatus.OK) {
        $scope.directionsDisplayForSearch.setMap($scope.mapSearchRoute);
        $scope.directionsDisplayForSearch.setDirections(response);
        $scope.directionForMap = {lat: route.startLatitud , lng: route.startLongitud};
      } else {
        window.alert('Directions request failed due to ' + status);
      }
    });     
};

$("#modalSearchRoute").on('shown.bs.modal', function () {
  google.maps.event.trigger($scope.mapSearchRoute, 'resize');
  $scope.mapSearchRoute.setCenter($scope.directionForMap);
  $scope.mapSearchRoute.setZoom(10);
});

$scope.request = function(routeIndex){
  $scope.requestRoute = $scope.searchResult[routeIndex];
};

$scope.aceptedRequestOfRoute = function() {
 $http.post( $scope.baseUrl + '/users/'+ $scope.user + '/suscribeRoute', $scope.requestRoute).success(function() {
    $scope.showRouteSuccess = true;
  }).error(function() {
    $scope.showRouteError = true;
  })
};

$scope.initRoute = function(){
  $scope.myRoutes(1);
};

$scope.initRoute();

} ]);
