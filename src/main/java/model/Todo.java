package model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jasypt.hibernate4.type.EncryptedBigDecimalType;
import org.jasypt.hibernate4.type.EncryptedBigIntegerAsStringType;
import org.jasypt.hibernate4.type.EncryptedBooleanAsStringType;
import org.jasypt.hibernate4.type.EncryptedDateAsStringType;
import org.jasypt.hibernate4.type.EncryptedFloatAsStringType;
import org.jasypt.hibernate4.type.EncryptedIntegerAsStringType;
import org.jasypt.hibernate4.type.EncryptedStringType;

@TypeDefs(value = {
		@TypeDef(name = "encryptedString", typeClass = EncryptedStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedInt", typeClass = EncryptedIntegerAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedBoolean", typeClass = EncryptedBooleanAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedDate", typeClass = EncryptedDateAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedBigInt", typeClass = EncryptedBigIntegerAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedFloat", typeClass = EncryptedFloatAsStringType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }),
		@TypeDef(name = "encryptedBigDecimal", typeClass = EncryptedBigDecimalType.class, parameters = { @Parameter(name = "encryptorRegisteredName", value = "strongHibernateStringEncryptor") }) })
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
	//@Type(type = "encryptedBigInt")
	BigInteger priority;

	@Column(name = "title")
	String title;

	@Column(name = "dueDate")
	@Type(type = "encryptedDate")
	Date dueDate;

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Todo(int id, String text, boolean isDone, BigInteger priority,
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

	public BigInteger getPriority() {
		return priority;
	}

	public void setPriority(BigInteger priority) {
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
