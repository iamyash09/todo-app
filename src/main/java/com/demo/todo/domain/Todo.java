package com.demo.todo.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Todo {
	
	public Todo() {}
	
	public Todo(String todoItem, String status, String dueDateTime) {
		// TODO Auto-generated constructor stub
		this.todoItem = todoItem;
		this.status = status;
		this.created_at = this.getCurrentDateTime();
		this.updated_at = this.getCurrentDateTime();
		this.dueDateTime = dueDateTime;
	}
	
	public String getCurrentDateTime(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));
		return dtf.format(now).toString();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String todoItem;
	private String status;
	private String created_at;
	private String updated_at;
	private String dueDateTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTodoItem() {
		return todoItem;
	}
	public void setTodoItem(String todoItem) {
		this.todoItem = todoItem;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getDueDateTime() {
		return dueDateTime;
	}

	public void setDueDateTime(String dueDateTime) {
		this.dueDateTime = dueDateTime;
	}

}