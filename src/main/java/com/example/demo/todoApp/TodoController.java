package com.example.demo.todoApp;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("*")
public class TodoController {

    private final TodoRepository todoRepository;

	private TodoService todoService;

	public TodoController(TodoService todoService, TodoRepository todoRepository) {
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}
	
	@GetMapping
	List<TodoApp> getTodos () {
		return todoService.getTodos();
	}
	
	@PostMapping
	void addTodo (@RequestBody TodoApp tooApp) {
		todoService.addTodo(tooApp);
	}
	
	@PutMapping("/{id}")
	TodoApp updateTodo (@PathVariable Long id, @RequestBody TodoApp todoApp) {
		return todoService.updateTodo(id, todoApp);
	}
	
	@DeleteMapping("/{id}")
	void deleteTodo (@PathVariable Long id) {
		todoService.deleteTodo(id);
	}
	
	
}
