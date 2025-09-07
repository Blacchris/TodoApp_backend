package com.example.demo.todoApp;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private TodoRepository todoRepository;
	
	
	public TodoService (TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	List<TodoApp> getTodos () {
		return todoRepository.findAll();
	}
	
	void addTodo (TodoApp todoApp) {
		todoRepository.save(todoApp);
	}
	
	void deleteTodo (Long id) {
		todoRepository.deleteById(id);
	}

	 TodoApp updateTodo(Long id, TodoApp todoApp) {
		TodoApp existingTodo = todoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Todo with id: "+ id +" does not exist"));
		existingTodo.setName(todoApp.getName());
		existingTodo.setDate(todoApp.getDate());
		
		return todoRepository.save(existingTodo);
	}

	
	
	
}
