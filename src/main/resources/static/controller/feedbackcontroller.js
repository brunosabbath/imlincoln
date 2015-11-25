var feedbackController = angular.module("feedbackController",[]);

feedbackController.controller('FeedbackController', ['$scope','$http',
	function($scope, $http) {

    $scope.sendForm = function(){

    	var obj = {
    		name: $scope.name,
    		email: $scope.email,
    		feedback: $scope.feedback
    	};

        $scope.loading = true;
    	    //$http.post("http://localhost:8080/events-server/feedback",obj).success(
            $http.post("http://eventslnk.elasticbeanstalk.com/feedback",obj).success(
	    	function(response) {
                $scope.loading = false;
	    		alert("thank you very much for your feedback");
	    	})
            .error(function(errormsg){
                $scope.loading = false;
                alert(errormsg.message)
            });
    };
	    
	}
]);