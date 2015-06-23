package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "todo")
public class Todo {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Type(type = "encryptedString")
	String text;

	@Column(name = "isDone", columnDefinition = "tinyint default false")
	// @Type(type="encryptedBoolean")
	boolean isDone;

	@Column(name = "priority")
	@Type(type = "encryptedInt")
	int priority;

	@Column(name = "title")
	String title;

	@Column(name = "dueDate")
	@Type(type = "encryptedDate")
	Date dueDate;

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Todo(int id, String text, boolean isDone, int priority,
			String title, Date dueDate) {
		super();
		this.id = id;
		this.text = text;
		this.isDone = isDone;
		this.priority = priority;
		this.title = title;
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", text=" + text + ", isDone=" + isDone
				+ ", priority=" + priority + ", title=" + title + ", dueDate="
				+ dueDate + "]";
	}

}
