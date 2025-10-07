package com.example.demo.TodoApp;

import com.example.demo.TodoApp.TodoDTOs.TodoResponseDTO;
import com.example.demo.TodoApp.TodoDTOs.TodoRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/todos")
@CrossOrigin(originPatterns = "*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDTO>> getAllTodos () {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TodoResponseDTO> getTodoById (@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PostMapping(path = "/{id}")
    public ResponseEntity<TodoResponseDTO> createTodo (@PathVariable Long id, @Valid  @RequestBody TodoRequestDTO todoRequestDTO) {
        TodoResponseDTO created = todoService.createTodo(id, todoRequestDTO);
        return ResponseEntity.created(URI.create("/api/" + created.getId()))
                .body(created);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TodoResponseDTO> updateTodo (@PathVariable Long id, @RequestBody TodoRequestDTO todoRequestDTO) {
        return ResponseEntity.ok(todoService.updateTodo(id, todoRequestDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTodoById (@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }


}
