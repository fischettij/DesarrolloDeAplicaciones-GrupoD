'use strict';

angular.module('desappGroupdFrontendApp')
.controller('route_ctrl', [ '$http', '$scope', '$window', '$cookies',
  '$locale', '$filter', 'baseUrl', function($http, $scope, $window, $cookies, $locale, $filter, baseUrl) {

  $scope.user = $cookies.get('user');
  $scope.listOfRoutes = [];
  $scope.searchResult = [];
  $scope.searchRoute = {};

  $scope.showRouteSuccess = false;
  $scope.showRouteError = false;

  $scope.daysOfWeek = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];

  $scope.vehicles = [];
  /// Paginacion
  
  $scope.amountPages = 0;
  $scope.page = 0;
  $scope.amountPagesSearchRoute = 0;
  $scope.pageSearchRoute = 0;

  $scope.howMuchMyRoutesRest = function(){
      $http.get( baseUrl + '/users/'+ $scope.user + '/howMuchMyRoutes').success(function(result) {
        $scope.amountPages = result;
      })
    };

    $scope.howMuchMyRoutes = function(){
      return Array.apply(null, {length: $scope.amountPages +1}).map(Number.call, Number);
    };

    $scope.getPage = function(){
      return scope.page;
    }

    $scope.pageIs = function(number){
      return number === $scope.page;
    }

    $scope.pageIsMax = function(){
      return $scope.amountPages === $scope.page;
    }

    $scope.routesPrevious = function(){
      $scope.myRoutes($scope.page -1);
    }

    $scope.routesNext = function(){
      $scope.myRoutes($scope.page +1);
    }

  $scope.howMuchSearchRoutesRest = function(){
      $http.post( baseUrl + '/routes/howMuchSearchRoutes',  $scope.searchRoute).success(function(result) {
        console.log(result);
        $scope.amountPagesSearchRoute = result;
      })
    };

    $scope.howMuchSearchRoutes = function(){
      return Array.apply(null, {length: $scope.amountPagesSearchRoute +1}).map(Number.call, Number);
    };

    $scope.getPageSearchRoute = function(){
      return scope.pageSearchRoute;
    }

    $scope.pageIsSearchRoute = function(number){
      return number === $scope.pageSearchRoute;
    }

    $scope.pageIsMaxSearchRoute = function(){
      return $scope.amountPagesSearchRoute === $scope.pageSearchRoute;
    }

    $scope.searchRoutesPrevious = function(){
      $scope.searchRoutes($scope.pageSearchRoute -1);
    }

    $scope.searchRoutesNext = function(){
      $scope.searchRoutes($scope.pageSearchRoute +1);
    }

  /// Fin Paginacion


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

///// End - Google Maps

$scope.myRoutes = function(page){
  $scope.page = page;
  $http.get( baseUrl + '/users/'+ $scope.user + '/routes/' + page).success(function(result) {
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
  $http.post( baseUrl + '/users/'+ $scope.user + '/newroute', {
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
    $scope.howMuchMyRoutesRest();
    $scope.myRoutes(0);
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

$scope.getAllVehicles = function(){
  $http.get( baseUrl + '/users/' + $scope.user + '/allvehicles').success(function(result){
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
        console.log(route.routeDaysOfWeek[1]);
        $scope.searchRoute = {
          startPoint: route.startingPoint,
          endPoint: route.endingPoint,
          startLatitud: $scope.startLocationLat,
          startLongitud: $scope.startLocationLng,
          endLatitud: $scope.endLocationLat, 
          endLongitud: $scope.endLocationLng,
          daysOfWeek: route.routeDaysOfWeek,
        }
        $scope.howMuchSearchRoutesRest(),
        $scope.searchRoutes(0);
      } else {
        window.alert('Directions request failed due to ' + status);
      }
    });

}

$scope.searchRoutes = function(page){
  $scope.pageSearchRoute = page;
  $http.post( baseUrl + '/routes/lookfor/'+ page, $scope.searchRoute).success(function(result) {
          $scope.searchResult = result;
          $scope.cleanLocations();
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
 $http.post( baseUrl + '/users/'+ $scope.user + '/suscribeRoute/' + $scope.requestRoute.owner.id + '/from/' + $scope.requestRoute.id).success(function() {
    $scope.showRouteSuccess = true;
  }).error(function() {
    $scope.showRouteError = true;
  })
};

$scope.initRoute = function(){
  $scope.myRoutes(0);
  $scope.howMuchMyRoutesRest();
};

// Subscription Request
$scope.subscriptionRequests = [];
$scope.routeID = 0;

$scope.initRoute();

$scope.openSubscriptionRequest = function(route){
  $http.get( baseUrl + '/routes/subscriptionrequests/' + route.id).success(function(result){
    $scope.subscriptionRequests = result;
    $scope.routeID = route.id;
  });
};

$scope.getSubscriptionRequest = function(){
  return $scope.subscriptionRequests;
};

$scope.acceptedRequest = function(subscriptionID){
  $http.post( baseUrl + '/users/'+ $scope.user + '/route/' +  $scope.routeID  + '/acceptedRequest/' + subscriptionID).success(function(result){});
}

$scope.denyRequest = function(subscriptionID){
  $http.post( baseUrl + '/users/'+ $scope.user + '/route/' +  $scope.routeID + '/denyRequest/' + subscriptionID).success(function(result){});
}


} ]);
