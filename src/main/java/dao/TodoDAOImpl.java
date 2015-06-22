package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Model.Todo;

@Repository
public class TodoDAOImpl implements TodoDAO {

	 SessionFactory sessionFactory; 

	 public TodoDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addTodo(Todo todo) {
		Session session = sessionFactory.openSession();
		session.save(todo);
		session.close();
	}

	public Todo getTodoById(int id) {
		Session session = sessionFactory.openSession();
		Criteria todoGetCriteria = session.createCriteria(Todo.class);
		todoGetCriteria.add(Restrictions.idEq(Integer.valueOf(id)));
		Todo todo = (Todo) todoGetCriteria.uniqueResult();
		session.close();
		return todo;
	}

	@Transactional
	public void removeTodo(Todo todo) {
        
		Session session = sessionFactory.openSession();

		Todo todo1 = (Todo) session.createCriteria(Todo.class).add(Restrictions.eq("id", todo.getId())).uniqueResult();
        session.delete(todo1);
        session.flush();
        session.close();
	}

	public List<Todo> listTodos() {
		Session session = sessionFactory.openSession();
		List<Todo> todos = session.createCriteria(Todo.class).list();
		session.close();
		return todos;
	}

	@Transactional
	public void updateTodo(int id, boolean isDone) {
		
		Session session = sessionFactory.openSession();
		Criteria todoGetCriteria = session.createCriteria(Todo.class);
		todoGetCriteria.add(Restrictions.idEq(Integer.valueOf(id)));
		Todo todo = (Todo) todoGetCriteria.uniqueResult();
		todo.setDone(isDone);		
		session.update(todo);
        session.flush();
		session.close();
	}

}
