package com.example.demo.TodoApp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("*")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping
    void addTodo (@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    @PutMapping(path = "id")
    void updateTodo (@PathVariable Long id,@RequestBody Todo todo) {
        todoService.updateTodo(id, todo);
    }

    @DeleteMapping
    void deleteTodo (@PathVariable Long id) {
        todoService.deleteTodo(id);
    }












}
