var eventController = angular.module("eventController",['ui.bootstrap.datepicker','dialogs']);

eventController.controller('WeekDetailsController', ['$scope','$http', '$routeParams',
	function($scope, $http, $routeParams) {
    //alert($routeParams.id);
      $scope.loading = true;
        //$http.get("http://eventslnk.elasticbeanstalk.com/event/id/" + $routeParams.id).success(
	      //$http.get("http://localhost:8080/events-server/event/id/" + $routeParams.id).success(
        $http.get("http://localhost:8080/event/" + $routeParams.id).success(
	    	function(response) {
	    		$scope.event = response;
          $scope.loading = false;
	    	})
        .error(function(errormsg){
          $scope.loading = false;
          alert(errormsg.message);
        });
	}
]);



eventController.controller('addEvent', ['$scope','$http', '$location','VenueService',

	function($scope, $http, $location ,VenueService) {	


	$scope.today = function() {
    $scope.startDate = new Date();
    $scope.endDate = new Date();
  };
  $scope.today();

  $scope.clear = function () {
    $scope.startDate = null;
    $scope.endDate = null;
  };

  // Disable weekend selection
  $scope.disabled = function(date, mode) {
    return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
  };

  $scope.toggleMin = function() {
    $scope.minDate = $scope.minDate ? null : new Date();
  };
  $scope.toggleMin();

  $scope.open = function($event, opened) {
    $event.preventDefault();
    $event.stopPropagation();

    $scope[opened] = true;
  };

  $scope.dateOptions = {
    formatYear: 'yy',
    startingDay: 1
  };

  $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
  $scope.format = $scope.formats[0];

  var tomorrow = new Date();
  tomorrow.setDate(tomorrow.getDate() + 1);
  var afterTomorrow = new Date();
  afterTomorrow.setDate(tomorrow.getDate() + 2);
  $scope.events =
    [
      {
        date: tomorrow,
        status: 'full'
      },
      {
        date: afterTomorrow,
        status: 'partially'
      }
    ];

  $scope.getDayClass = function(date, mode) {
    if (mode === 'day') {
      var dayToCheck = new Date(date).setHours(0,0,0,0);

      for (var i=0;i<$scope.events.length;i++){
        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

        if (dayToCheck === currentDay) {
          return $scope.events[i].status;
        }
      }
    }

    return '';
  };

  $scope.startTime = new Date();
  $scope.endTime = new Date();

  $scope.hstep = 1;
  $scope.mstep = 1;

  $scope.options = {
    hstep: [1, 2, 3],
    mstep: [1, 5, 10, 15, 25, 30]
  };

  $scope.ismeridian = false;
  $scope.toggleMode = function() {
    $scope.ismeridian = ! $scope.ismeridian;
  };

  $scope.update = function() {
    var d = new Date();
    d.setHours( 14 );
    d.setMinutes( 0 );
    $scope.startTime = d;
    $scope.endTime = d;
  };

  $scope.changed = function () {
    //console.log('Time changed start: ' + $scope.startTime);
    //console.log('Time changed end: ' + $scope.endTime);
  };

  $scope.clear = function() {
    $scope.mytime = null;
  };
  /*
  /end date/time picker 
  */

		var venues = [];
    $scope.tags = [];
		var venue;
		$scope.venues = [];

		VenueService.listVenue().then(function(objs){
			venues = objs.data;
			$scope.venues = objs.data;
		},
		function(date){
			alert("Sorry, we couldnt load venues");
		});

    $scope.addTag = function(){
      $scope.tags.push({nameTag: $scope.nameTag});
      $scope.nameTag = "";
    };

    $scope.removeTag = function(index){
      $scope.tags.splice(index, 1);
    };

		$scope.selectVenue = function(){
			venue = $scope.venue;
			$scope.address = venue.address;
		};

    function getTags(){
      return $scope.tags;
    };

    function getVenue(){
      return venue;
    }

    function buildDate(date,time){
      return new Date(date.getFullYear(), date.getMonth(), date.getDate(), time.getHours(), time.getMinutes());
    };

		$scope.sendForm = function(){
			var obj = {eventName: $scope.eventName, 
						  address: $scope.address, 
					   	eventDescription: $scope.eventDescription,  
              startDate: buildDate($scope.startDate,$scope.startTime),
              endDate: buildDate($scope.endDate,$scope.endTime),
              tags: getTags(),
              password: $scope.password,
              venue: getVenue()
             };  
      
      $scope.loading = true;
      var resp = $http.post("http://localhost:8080/event",obj);
      //var resp = $http.post("http://localhost:8080/events-server/event",obj);
      //var resp = $http.post("http://eventslnk.elasticbeanstalk.com/event",obj);
      resp.success(function(){
        $scope.loading = false;
        alert("successfully added");
        $location.path("/today");
      });
      resp.error(function(errormsg){
        $scope.loading = false;
        alert(errormsg.message);
      });
			
		};
	}

]);


eventController.controller('EditEventController', ['$scope','$http', '$routeParams','VenueService',
  function($scope, $http, $routeParams, VenueService) {

  $scope.today = function() {
    $scope.startDate = new Date();
    $scope.endDate = new Date();
  };
  $scope.today();

  $scope.clear = function () {
    $scope.startDate = null;
    $scope.endDate = null;
  };

  // Disable weekend selection
  $scope.disabled = function(date, mode) {
    return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
  };

  $scope.toggleMin = function() {
    $scope.minDate = $scope.minDate ? null : new Date();
  };
  $scope.toggleMin();

  $scope.open = function($event, opened) {
    $event.preventDefault();
    $event.stopPropagation();

    $scope[opened] = true;
  };

  $scope.dateOptions = {
    formatYear: 'yy',
    startingDay: 1
  };

  $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
  $scope.format = $scope.formats[0];

  var tomorrow = new Date();
  tomorrow.setDate(tomorrow.getDate() + 1);
  var afterTomorrow = new Date();
  afterTomorrow.setDate(tomorrow.getDate() + 2);
  $scope.events =
    [
      {
        date: tomorrow,
        status: 'full'
      },
      {
        date: afterTomorrow,
        status: 'partially'
      }
    ];

  $scope.getDayClass = function(date, mode) {
    if (mode === 'day') {
      var dayToCheck = new Date(date).setHours(0,0,0,0);

      for (var i=0;i<$scope.events.length;i++){
        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

        if (dayToCheck === currentDay) {
          return $scope.events[i].status;
        }
      }
    }

    return '';
  };

  $scope.startTime = new Date();
  $scope.endTime = new Date();

  $scope.hstep = 1;
  $scope.mstep = 1;

  $scope.options = {
    hstep: [1, 2, 3],
    mstep: [1, 5, 10, 15, 25, 30]
  };

  $scope.ismeridian = false;
  $scope.toggleMode = function() {
    $scope.ismeridian = ! $scope.ismeridian;
  };

  $scope.update = function() {
    var d = new Date();
    d.setHours( 14 );
    d.setMinutes( 0 );
    $scope.startTime = d;
    $scope.endTime = d;
  };

  $scope.changed = function () {
    //console.log('Time changed start: ' + $scope.startTime);
    //console.log('Time changed end: ' + $scope.endTime);
  };

  $scope.clear = function() {
    $scope.mytime = null;
  };
  /*
  /end date/time picker 
  */

    var venues = [];
    $scope.tags = [];
    var venue;
    $scope.venues = [];

    var city;

    VenueService.listVenue().then(function(objs){
      venues = objs.data;
      $scope.venues = objs.data;
    },
    function(date){
      alert("Sorry, we couldnt load venues");
    });

    $scope.addTag = function(){
      $scope.tags.push({nameTag: $scope.nameTag});
      $scope.nameTag = "";
    };

    $scope.removeTag = function(index){
      $scope.tags.splice(index, 1);
    };

    $scope.selectVenue = function(){
      venue = $scope.venue;
      $scope.address = venue.address;
    };

    function getTags(){
      return $scope.tags;
    };

    function getVenue(){
      return venue;
    };

    function buildDate(date,time){
      return new Date(date.getFullYear(), date.getMonth(), date.getDate(), time.getHours(), time.getMinutes());
    };

    $scope.updateForm = function(){
        var obj = {
              id: $routeParams.id,
              eventName: $scope.eventName, 
              address: $scope.address, 
              eventDescription: $scope.eventDescription,  
              startDate: buildDate($scope.startDate,$scope.startTime),
              endDate: buildDate($scope.endDate,$scope.endTime),
              tags: getTags(),
              password: $scope.password,
              venue: getVenue(),
              city: city
             };  
      
      $scope.loading = true;
      var resp = $http.put("http://localhost:8080/event",obj);
      //var resp = $http.put("http://localhost:8080/events-server/event",obj);
      //var resp = $http.put("http://eventslnk.elasticbeanstalk.com/event",obj);
      resp.success(function(){
        $scope.loading = false;
        alert("successfully updated");
        $location.path("/today");
      });
      resp.error(function(errormsg){
        $scope.loading = false;
        alert(errormsg.message);
      });
    };

    $http.get("http://localhost:8080/event/id/" + $routeParams.id).success(
    //$http.get("http://localhost:8080/events-server/event/id/" + $routeParams.id).success(
    //$http.get("http://eventslnk.elasticbeanstalk.com/event/id/" + $routeParams.id).success(  
    function(response) {
        //$scope.event = response;
        for(i=0; i < response.tags.length; i++)
          $scope.tags.push({nameTag: response.tags[i].nameTag});

        city = response.city;
        $scope.eventName = response.eventName;
        $scope.eventDescription = response.eventDescription;
        $scope.address = response.address;
        $scope.password = response.password;
    });
  }
]);

eventController.controller('WeekController',['$scope','$http','$modal','$location',
	function($scope, $http, $modal, $location){

    var action;

    $scope.editDeleteEvent = function(index,actionFromForm){
      action = actionFromForm;
      var modalInstance = $modal.open({
      templateUrl: 'myModalContent.html',
      controller: 'ModalInstanceCtrl'
    });

    modalInstance.result.then(function (password) {
      
      var obj = {previousPassword: $scope.events[index].password,
                 inputPassword: password};
      
      
      $scope.loading = true;
      var resp = $http.post("http://localhost:8080/password/validate",obj);
      //var resp = $http.post("http://localhost:8080/events-server/password/validate",obj);
      //var resp = $http.post("http://eventslnk.elasticbeanstalk.com/password/validate",obj);
      resp.success(function(){
        
        if(action == "edit")
          $location.path("/editevent/" + $scope.events[index].id);
        else{
          
          var deleteEvent = $http.delete("http://localhost:8080/event/" + $scope.events[index].id);
          //var deleteEvent = $http.delete("http://localhost:8080/events-server/event/" + $scope.events[index].id);
          //var deleteEvent = $http.delete("http://eventslnk.elasticbeanstalk.com/event/" + $scope.events[index].id);
          deleteEvent.success(function(){
            $scope.loading = false;
            alert("event deleted");
            $location.path("/week");
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
      $http.get("http://localhost:8080/event/week").success(
		  //$http.get("http://localhost:8080/events-server/event/week").success(
      //$http.get("http://eventslnk.elasticbeanstalk.com/event/week").success(
			function(response){
        $scope.loading = false;
				$scope.events = response;
			})
      .error(function(errormsg){
        $scope.loading = false;
        $scope.errormsg = errormsg.message;
      });
	}
]);

eventController.controller('ModalInstanceCtrl',function($scope,$modalInstance){
  $scope.ok = function () {
    $modalInstance.close($scope.texto);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});

eventController.controller('TodayController', ['$scope','$http', '$modal', '$location',
                                           	function($scope, $http, $modal, $location) {
	
	$scope.user = "";
	
	$http.get('auth').success(function(token) {
		$http({
			url : 'http://localhost:8080/auth',
			method : 'GET',
			headers : {
				'X-Auth-Token' : token.token
			}
		}).success(function(data) {
			//alert(data.principal.username);
			$scope.user = data.principal.username;
		});
	});
	
	  $scope.itemsPerPage = 9;
	  $scope.currentPage = 0;
	  $scope.total = 50;
	  //$scope.total = Item.total();
	  //$scope.pagedItems = Item.get($scope.currentPage*$scope.itemsPerPage, $scope.itemsPerPage);

	  	$http.get('http://localhost:8080/event/pages/0').success(function(data) {
	  		$scope.events = data;
		});
	  
	  $scope.loadMore = function() {
	    $scope.currentPage++;
	    
	    $http.get('http://localhost:8080/event/pages/'+$scope.currentPage).success(function(data) {
	    	newItems = data;
	    	$scope.events = $scope.events.concat(data);
		});
	    //alert(newItems);
	    //var newItems = Item.get($scope.currentPage*$scope.itemsPerPage, $scope.itemsPerPage);
	    
	  };

	  $scope.nextPageDisabledClass = function() {
	    return $scope.currentPage === $scope.pageCount()-1 ? "disabled" : "";
	  };

	  $scope.pageCount = function() {
	    return Math.ceil($scope.total/$scope.itemsPerPage);
	  };
}]);


eventController.controller('MyUpcomingEventsController', ['$scope','$http', '$modal', '$location',function($scope, $http, $modal, $location) {

	var user = "";
	alert("myevents");
   	$http.get('auth').success(function(token) {
   		$http({
   			url : 'http://localhost:8080/auth',
   			method : 'GET',
   			headers : {
   				'X-Auth-Token' : token.token
   			}
   		}).success(function(data) {
   			user = data.principal.username;
   		});
   	});

   	alert("user: "+user);
   	 
}]);

/*
eventController.controller('TodayController', ['$scope','$http', '$modal', '$location',
	function($scope, $http, $modal, $location) {

    var action;

    $scope.editDeleteEvent = function(index,actionFromForm){
      action = actionFromForm;
      var modalInstance = $modal.open({
      templateUrl: 'myModalContent.html',
      controller: 'ModalInstanceCtrl'
    });

    modalInstance.result.then(function (password) {
      var obj = {previousPassword: $scope.events[index].password,
                 inputPassword: password};
      
      
      $scope.loading = true;
      var resp = $http.post("http://localhost:8080/password/validate",obj);
      //var resp = $http.post("http://localhost:8080/events-server/password/validate",obj);
      //var resp = $http.post("http://eventslnk.elasticbeanstalk.com/password/validate",obj);
      resp.success(function(){
        
        if(action == "edit")
          $location.path("/editevent/" + $scope.events[index].id);
        else{
          
          var deleteEvent = $http.delete("http://localhost:8080/event/" + $scope.events[index].id);
          //var deleteEvent = $http.delete("http://localhost:8080/events-server/event/" + $scope.events[index].id);
          //var deleteEvent = $http.delete("http://eventslnk.elasticbeanstalk.com/event/" + $scope.events[index].id);
          deleteEvent.success(function(){
            $scope.loading = false;
            alert("event deleted");
            $location.path("/week");
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
        $http.get("http://localhost:8080/event/available").success(
	      //$http.get("http://localhost:8080/events-server/event/today").success(
        //$http.get("http://eventslnk.elasticbeanstalk.com/event/today").success(
	    	function(response) {
          $scope.loading = false;
	    		$scope.events = response;
	    	})
        .error(function(error){
          $scope.loading = false;
          $scope.errormsg = error.message;
        });
	}    
]);*/