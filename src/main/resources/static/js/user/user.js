(function(){
	function userCtrl($scope,$http){
		$http.post("user/userlist",{}).then(
			function success(data){
				$scope.userlist = data.data;
				console.log(data);
			},
			function error(data){
				console.log(data);
			}
		);
	}
	var app = angular.module("userApp",[]);
	app.controller("userCtrl",userCtrl);
	
})()