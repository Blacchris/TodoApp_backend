package com.example.demo.todoApp;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin("*") 
public class UserController {

    private final TodoService todoService;
	
	private UserService userService;

	public UserController(UserService userService, TodoService todoService) {
		this.userService = userService;
		this.todoService = todoService;
	}
	
	@GetMapping
	List<User> getUsers () {
		return userService.getUsers();
	}
	
	@PostMapping
	User addUser (@RequestBody User user) {
		return userService.addUser(user);
	}
	
}
