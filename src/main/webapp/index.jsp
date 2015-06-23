
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
									<input type="text" ng-model="todo.priority"
									class="form-control input" id="" placeholder="Priority">
									<button type="button" ng-click="add(todo)"
										class="btn btn-primary pull-right">Add</button>
								</div>
							</form>
						</div>

						<table class="table">
							<thead>
								<tr>
									<th>ID</th>
									<th>Text</th>
									<th>Priority</th>
									<th>X</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="todo in todos">
									<td>{{todo.id }}</td>
									<td><label> <input
									type="checkbox" class="todoList" ng-click="update(todo)"
									ng-true-value="true" ng-false-value="false"
									ng-model="todo.done"> {{ todo.text }}
							</label></td>
									<td><label class="label_priority"> {{ todo.priority }} </label></td>
									<td><button type="button" ng-click="delete(todo)" class="close">x</button></td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>

			</div>

		</div>
	</div>


	<script>
			angular.module('todo', [])
			.controller('controller', ['$scope', '$http', function($scope, $http) {

				$scope.master = {};

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
				isDone : "YES",
				priority : todo.priority
			};

			$http.post("http://localhost:8080/TodoApp/todo",dataObj).success(
				function(data, status, headers, config)
				{
					$scope.reload();
				});
		};

		$scope.delete = function(todo)
		{
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
