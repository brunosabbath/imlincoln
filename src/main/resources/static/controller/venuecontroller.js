var venueController = angular.module("venueController",['dialogs']);

venueController.service('VenueService', function($http){
	return {
		listVenue: function(){

			  //var resp = $http.get("http://localhost:8080/events-server/venue/").success(
        var resp = $http.get("http://localhost:8080/venue/").success(
        //var resp = $http.get("http://eventslnk.elasticbeanstalk.com/venue/").success(
				function(response){
					var venues = [];
					for(var i = 0; i < response.length; i++){
						venues.push(response[i]);
					}
					return venues;
			});
			return resp;
		}
	}
});

venueController.controller('VenueDetailsController', ['$scope','$http', '$routeParams',
	function($scope, $http, $routeParams) {
    
      $scope.loading = true;
        $http.get("http://localhost:8080/venue/" + $routeParams.id).success(
	      //$http.get("http://localhost:8080/events-server/venue/" + $routeParams.id).success(
        //$http.get("http://eventslnk.elasticbeanstalk.com/venue/" + $routeParams.id).success(
	    	function(response) {
	    		$scope.venue = response;
          $scope.loading = false;
	    	})
        .error(function(errormsg){
          $scope.loading = false;
          alert(errormsg.message);
        });
	}
]);

venueController.controller('addVenue', ['$scope','$http',
	function($scope, $http) {
		$scope.sendForm = function(){
			var obj = {venueName: $scope.venueName, 
						  venueDescription: $scope.venueDescription, 
					   	website: $scope.website, 
					   	facebook: $scope.facebook, 
					   	twitter: $scope.twitter, 
					   	address: $scope.address, 
					   	email: $scope.email, 
					   	password: $scope.password,
              telephone: $scope.telephone
             };
					   	
      $scope.loading = true;
      var resp = $http.post("http://localhost:8080/venue",obj);
			//var resp = $http.post("http://localhost:8080/events-server/venue",obj);
      //var resp = $http.post("http://eventslnk.elasticbeanstalk.com/venue",obj);
			resp.success(function(){
        $scope.loading = false;
				alert("venue added successfully");
			});
			resp.error(function(errormsg){
        $scope.loading = false;
				alert(errormsg.message);
			});
		};
	}
]);

venueController.controller('VenueController',['$scope','$http','$modal','$location',
	function($scope, $http, $modal, $location){

	var action;

    $scope.editDeleteVenue = function(index,actionFromForm){
      action = actionFromForm;
      var modalInstance = $modal.open({
      templateUrl: 'myModalContent.html',
      controller: 'ModalInstanceCtrl'
    });

    modalInstance.result.then(function (password) {
      console.log(action);
      var obj = {previousPassword: $scope.venues[index].password,
                 inputPassword: password};
      
      $scope.loading = true;
      var resp = $http.post("http://localhost:8080/password/validate",obj);
      //var resp = $http.post("http://localhost:8080/events-server/password/validate",obj);
      //var resp = $http.post("http://eventslnk.elasticbeanstalk.com/password/validate",obj);
      resp.success(function(){
        
        if(action == "edit")
          $location.path("/editvenue/" + $scope.venues[index].id);
        else{
          var deleteEvent = $http.delete("http://localhost:8080/venue/" + $scope.venues[index].id);
          //var deleteEvent = $http.delete("http://localhost:8080/events-server/venue/" + $scope.venues[index].id);
          //var deleteEvent = $http.delete("http://eventslnk.elasticbeanstalk.com/venue/" + $scope.venues[index].id);
          deleteEvent.success(function(){
            alert("venue deleted");
            $scope.loading = false;
            $location.path("/venue");
          });
          deleteEvent.error(function(errormsg){
            $scope.loading = false;
            alert(errormsg.message);
          });
        }

      });
      resp.error(function(errormsg){
        $scope.loading = false;
        alert(errormsg.message);
      });
    }, function () {
      //in case of cancel button pressed
      //console.log("cancel");
    });
      
    };

      $scope.loading = true;
      $http.get("http://localhost:8080/venue/").success(
		  //$http.get("http://localhost:8080/events-server/venue/").success(
      //$http.get("http://eventslnk.elasticbeanstalk.com/venue/").success(
			function(response){
				$scope.venues = response;
        $scope.loading = false;
			})
      .error(function(errormsg){
        //alert(errormsg.message);
        $scope.errormsg = errormsg.message;
        $scope.loading = false;
      });
	}
]);


venueController.controller('EditVenueController', ['$scope','$http', '$routeParams',
  function($scope, $http, $routeParams) {

    $scope.updateForm = function(){

      var obj = {id: $routeParams.id,
      					venueName: $scope.venueName, 
  						  venueDescription: $scope.venueDescription, 
  					   	website: $scope.website, 
  					   	facebook: $scope.facebook, 
  					   	twitter: $scope.twitter, 
  					   	address: $scope.address, 
  					   	email: $scope.email, 
  					   	password: $scope.password,
                telephone: $scope.telephone
             };  

      $scope.loading = true;
      var resp = $http.put("http://localhost:8080/venue",obj);
      //var resp = $http.put("http://localhost:8080/events-server/venue",obj);
      //var resp = $http.put("http://eventslnk.elasticbeanstalk.com/venue",obj);

      resp.success(function(){
        $scope.loading = false;
        alert("venue updated");
        $location.path("/venues");
      });
      resp.error(function(error){
        $scope.loading = false;
        alert(error.message);
      });
    };


    $http.get("http://localhost:8080/venue/" + $routeParams.id).success(
    //$http.get("http://localhost:8080/events-server/venue/" + $routeParams.id).success(
    //$http.get("http://eventslnk.elasticbeanstalk.com/venue/" + $routeParams.id).success(
    function(response) {

        $scope.venueName = response.venueName;
        $scope.venueDescription = response.venueDescription;
        $scope.address = response.address;
        $scope.password = response.password;
        $scope.website = response.website;
        $scope.email = response.email;
        $scope.facebook = response.facebook;
        $scope.twitter = response.twitter;
        $scope.telephone = response.telephone;

    });
  }
]);

venueController.controller('ModalInstanceCtrl',function($scope,$modalInstance){
  $scope.ok = function () {
    $modalInstance.close($scope.texto);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});