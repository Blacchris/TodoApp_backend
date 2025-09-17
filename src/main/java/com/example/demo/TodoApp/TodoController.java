package com.example.demo.TodoApp;

import com.example.demo.TodoApp.TodoDTOs.TodoDTO;
import com.example.demo.TodoApp.TodoDTOs.TodoRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    List<TodoDTO> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/{id}/todos")
    TodoDTO addTodo (@PathVariable Long id, @RequestBody TodoRequestDTO todoRequestDTO) {
        return todoService.addTodo(id, todoRequestDTO);
    }

    @PutMapping("/{id}")
    Todo updateTodo (@PathVariable Long id,@RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    void deleteTodo (@PathVariable Long id) {
        todoService.deleteTodo(id);
    }












}
