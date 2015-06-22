
<html>
<head>
<title>ToDo Creater</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/todo.css">
</head>
<body class="app">

	<div ng-app="todo" ng-controller="controller" ng-init="reload()">
		<div class="container">
			<div class="row">

				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div align="center">
						<legend>Todo creater</legend>
						<div class="row">
							<form class="form-inline">
								<div class="form-group">
									<input type="text" ng-model="todo.text"
										class="form-control input" id="" placeholder="Text" required
										autofocus>
									<button type="button" ng-click="add(todo)"
										class="btn btn-primary pull-right">Add</button>
								</div>
							</form>
						</div>
						<div class="checkbox1" ng-repeat="todo in todos">
							<li class="list-unstyled" align="left"><label> 
							<input type="checkbox" class="todoList" ng-click="update(todo)" ng-true-value="true" ng-false-value="false" ng-model="todo.done">
									{{ todo.text }}
							</label>
								<button type="button" ng-click="delete(todo)"
									class="close">x</button></li>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>


	<script>
			angular.module('todo', [])
			.controller('controller', ['$scope', '$http', function($scope, $http) {

				$scope.master = {};

		// $scope.todos = [
		// {id : 1, text : "Write an Angular js Tutorial for Todo-List" , isDone : false },
		// {id : 2, text : "Update jquer.in" , isDone : false },
		// {id : 3, text : "Create a brand-new Resume" , isDone : false }
		// ];

		$scope.reload = function()
		{
			$http.get("http://localhost:8080/TodoApp/todo").success(
				function(data, status, headers, config)
				{
					$scope.todos = data;
				});
		}

		$scope.add = function(todo)
		{
			var dataObj = {
				text : todo.text,
				isDone : "YES"
			};

			$http.post("http://localhost:8080/TodoApp/todo",dataObj).success(
				function(data, status, headers, config)
				{
					$scope.reload();
				});

			//$scope.todos.push(dataObj);
		};

		$scope.delete = function(todo)
		{
			//$scope.todos.splice($scope.todos.indexOf(todo),1);

			$http.post("http://localhost:8080/TodoApp/removeTodo",todo).success(
				function(data, status, headers, config)
				{
					$scope.reload();
				});
		}

		$scope.update = function(todo)
		{
			$http.post("http://localhost:8080/TodoApp/updateTodo",todo).success(
				function(data, status, headers, config)
				{
					$scope.reload();
				});
		}

	}]);
		</script>
</body>
</html>

<!-- 	
<html>
Controller
<script>
var sampleApp = angular.module('App', []);
sampleApp.config(['$routeProvider',function($routeProvider) {
$routeProvider.when('/todo', {
templateUrl:'todo.html',
controller:'todoController'
}).otherwise({
redirectTo:'/todo'
}
);

}]);

sampleApp.controller('todoController', ['', function($scope){
	$scope.message = "todoController";
}])
</script>
</html> -->
