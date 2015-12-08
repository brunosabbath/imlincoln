var app = angular.module('app', ['ui.bootstrap','ngRoute','eventController','venueController','feedbackController']);

app.factory('rememberService', function() {
    return {
        scrollTop: undefined
    };
});

app.directive('scroller', function($timeout, rememberService) {
    return {
        restrict: 'A', // this gets tacked on to an existing <div>
        scope: {},
        link: function(scope, elm, attrs) {
            var raw = elm[0];  // get raw element object to access its scrollTop property
            
            elm.bind('scroll', function() {
                // remember where we are
                rememberService.scrollTop = raw.scrollTop;
            });

            // Need to wait until the digest cycle is complete to apply this property change to the element.
            $timeout(function() {
                raw.scrollTop = rememberService.scrollTop;
            });
        }
    };
});

app.config(function($routeProvider, $httpProvider){
	
	$routeProvider.
			when('/today',{
				templateUrl: 'partials/events.html',
				controller: 'TodayController'
			}).
			when('/week',{
				templateUrl: 'partials/events.html',
				controller: 'WeekController'
			}).
			when('/week/:id',{
				templateUrl: 'partials/detailEvent.html',
				controller: 'WeekDetailsController'
			}).
			when('/recommended',{
				templateUrl: 'partials/recommended.html'
				//controller: 'RecommendedController'
			}).
			when('/liked',{
				templateUrl: 'partials/liked.html'
				//controller: 'LikedController'
			}).
			when('/venues',{
				templateUrl: 'partials/venues.html',
				controller: 'VenueController'
			}).
			when('/venues/:id',{
				templateUrl: 'partials/detailVenue.html',
				controller: 'VenueDetailsController'
			}).
			when('/addvenue',{
				templateUrl: 'partials/addVenue.html'
			}).
			when('/addevent',{
				templateUrl: 'partials/addEvent.html'
				//controller: 'VenueController'
			}).
			when('/editevent/:id',{
				templateUrl: 'partials/editEvent.html',
				controller: 'EditEventController'
			}).
			when('/editvenue/:id',{
				templateUrl: 'partials/editVenue.html',
				controller: 'EditVenueController'
			}).
			when('/feedback',{
				templateUrl: 'partials/feedback.html'
			}).
			when('/about',{
				templateUrl: 'partials/about.html'
			}).
			when('/login',{
				templateUrl: 'partials/login.html'
			}).
			otherwise({redirectTo: '/today'});
	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	
});

app.controller('login', function($rootScope, $scope, $http, $location, $route) {

	$scope.tab = function(route) {
		return $route.current && route === $route.current.controller;
	};
	
	var authenticate = function(credentials, callback) {

		var headers = credentials ? {authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)} : {};

		$http.get('http://localhost:8080/auth', { headers : headers }).success(function(data) {
			if (data.name) {
				$rootScope.authenticated = true;
			} else {
				$rootScope.authenticated = false;
			}
			callback && callback();
		}).error(function() {
			$rootScope.authenticated = false;
			callback && callback();
		});

	}

	authenticate();

	$scope.credentials = {};
	
	$scope.login = function() {
		authenticate($scope.credentials, function() {
			if ($rootScope.authenticated) {
				console.log("Login succeeded")
				$location.path("/");
				$scope.error = false;
				$rootScope.authenticated = true;
			} else {
				console.log("Login failed")
				$location.path("/login");
				$scope.error = true;
				$rootScope.authenticated = false;
			}
		})
	};

	$scope.logout = function() {
		$http.post('http://localhost:8080/logout', {}).success(function() {
			console.log("worked");
			$rootScope.authenticated = false;
			$location.path("/");
		}).error(function(data) {
			console.log("Logout failed")
			$rootScope.authenticated = false;
		});
	}

});

/*
app.config(['$routeProvider', function($routeProvider){

		$routeProvider.
			when('/today',{
				templateUrl: 'partials/events.html',
				controller: 'TodayController'
			}).
			when('/week',{
				templateUrl: 'partials/events.html',
				controller: 'WeekController'
			}).
			when('/week/:id',{
				templateUrl: 'partials/detailEvent.html',
				controller: 'WeekDetailsController'
			}).
			when('/recommended',{
				templateUrl: 'partials/recommended.html'
				//controller: 'RecommendedController'
			}).
			when('/liked',{
				templateUrl: 'partials/liked.html'
				//controller: 'LikedController'
			}).
			when('/venues',{
				templateUrl: 'partials/venues.html',
				controller: 'VenueController'
			}).
			when('/venues/:id',{
				templateUrl: 'partials/detailVenue.html',
				controller: 'VenueDetailsController'
			}).
			when('/addvenue',{
				templateUrl: 'partials/addVenue.html'
			}).
			when('/addevent',{
				templateUrl: 'partials/addEvent.html'
				//controller: 'VenueController'
			}).
			when('/editevent/:id',{
				templateUrl: 'partials/editEvent.html',
				controller: 'EditEventController'
			}).
			when('/editvenue/:id',{
				templateUrl: 'partials/editVenue.html',
				controller: 'EditVenueController'
			}).
			when('/feedback',{
				templateUrl: 'partials/feedback.html'
			}).
			when('/about',{
				templateUrl: 'partials/about.html'
			}).
			otherwise({redirectTo: '/today'});

}]);*/