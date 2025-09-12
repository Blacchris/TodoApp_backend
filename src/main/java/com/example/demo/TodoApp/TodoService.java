package com.example.demo.TodoApp;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    List<Todo> getTodos () {
        return todoRepository.findAll();
    }
    void addTodo (Todo todo) {
        todoRepository.save(todo);
    }

    void updateTodo (Long id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + "is not found!"));
        existingTodo.setName(todo.getName());
        existingTodo.setDate(todo.getDate());
        existingTodo.setDescription(todo.getDescription());
        todoRepository.save(existingTodo);
    }

    void deleteTodo (Long id) {
        todoRepository.deleteById(id);
    }





}
