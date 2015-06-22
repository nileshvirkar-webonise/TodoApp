package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Model.Todo;
import dao.TodoDAO;

@Service
public class TodoServicesImpl implements TodoServices {

	TodoDAO dataDao;  
	 	
	public TodoServicesImpl(TodoDAO dataDao) {
		super();
		this.dataDao = dataDao;
	}

	@Transactional
	public void addTodo(Todo todo) {
		// TODO Auto-generated method stub
		
		dataDao.addTodo(todo);
	}

	public Todo getTodoById(int id) {
		// TODO Auto-generated method stub
		
		return dataDao.getTodoById(id);
	}

	@Transactional
	public void removeTodo(Todo todo) {
		// TODO Auto-generated method stub
		
		dataDao.removeTodo(todo);
	}

	public List<Todo> listTodos() {
		// TODO Auto-generated method stub
		
		return dataDao.listTodos();
	}

	@Transactional
	public void updateTodo(int id, boolean isDone) {
		// TODO Auto-generated method stub
		
		dataDao.updateTodo(id, isDone);
	}

}
