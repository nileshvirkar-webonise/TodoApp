<html>

<script>
var sampleApp = angular.module('App', []);
sampleApp.config(['$routeProvider',function($routeProvider) {
$routeProvider.when('/todo', {
templateUrl:'todo.html'
controller:'todoController'
}).otherwise({
redirectTo:
}
);

}]);

sampleApp.controller('todoController', ['', function($scope){
	$scope.message = "todoController";
}])
</script>
</html>