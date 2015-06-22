package controller;

import java.util.List;

import model.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import services.TodoServices;

@Controller
class TodoController {

	@Autowired
	TodoServices dataServices;

	@RequestMapping("/")
	public String getIndexView() {
		return "index";
	}

	@RequestMapping(value = "todo", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void createTodo(@RequestBody Todo todo) {
		System.out.println("todo: " + todo.toString());
		//todo.setDueDate(new Date());
		dataServices.addTodo(todo);
	}

	@RequestMapping(value = "todo", method = RequestMethod.GET)
	public @ResponseBody List<Todo> displayTodo() {
		List<Todo> todoList = dataServices.listTodos();
		return todoList;
	}

	@RequestMapping(value = "removeTodo", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void removeTodo(@RequestBody Todo todo) {
		dataServices.removeTodo(todo);
	}

	@RequestMapping(value = "updateTodo", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void updateTodo(@RequestBody Todo todo) {
		System.out.println("updateTodo");
		//boolean isDone = !todo.isDone();
		dataServices.updateTodo(todo.getId(), todo.isDone());
	}
}
