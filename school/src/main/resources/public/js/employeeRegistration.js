var app = angular.module('myApp', []);

app.controller('validateCtrl', function($scope,$http) {
	
	$scope.designations = [
        {des:"Principal"},
        {des:"Teachers"},
        {des:"Clerk"}
    ];
	$scope.jobTypes = [
        {jt:"Full Time"},
        {jt:"Part Time"}
    ];
	$scope.sex="male";
	 $scope.reset = function() {
		 $scope.name="";
				 
		  };
		  $scope.addEmployee=function(){
			    var req = {
			  		 method: 'POST',
			  		 url: '/employees/add',
			  		 headers: {
			  		   'Content-Type': 'application/json; charset=UTF-8'
			  		 },
			  		 data: {
			  			  
			  			}
			  		};

			  		$http(req).then(function(response){console.log(response.data);}, function(response){console.log(response.data);});
			  
		  };
		  
});