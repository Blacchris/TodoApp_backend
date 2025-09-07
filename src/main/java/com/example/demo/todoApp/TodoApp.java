package com.example.demo.todoApp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class TodoApp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public TodoApp () {}

	public TodoApp(Long id, String name, String date, User user) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.user = user;
	}

	public TodoApp(String name, String date, User user) {
		super();
		this.name = name;
		this.date = date;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	};
	
	

	
	
}
