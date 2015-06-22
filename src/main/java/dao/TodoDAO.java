package dao;

import java.util.List;

import model.Todo;

public interface TodoDAO {

	public void addTodo(Todo todo);
	public Todo getTodoById(int id);
	public List<Todo> listTodos();
	public void removeTodo(Todo todo);
	public void updateTodo(int id, boolean isDone);
	
}
