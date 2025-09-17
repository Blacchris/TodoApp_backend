package com.example.demo.TodoApp;

import com.example.demo.TodoApp.TodoDTOs.TodoRequestDTO;
import com.example.demo.TodoApp.TodoDTOs.TodoDTO;
import com.example.demo.TodoApp.TodoDTOs.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final UsersRepository usersRepository;

    public TodoService(TodoRepository todoRepository, UsersRepository usersRepository) {
        this.todoRepository = todoRepository;
        this.usersRepository = usersRepository;
    }

    List<TodoDTO> getTodos () {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoDTO(
                        todo.getId(),
                        todo.getName(),
                        todo.getDate(),
                        todo.getDescription(),
                        (todo.getUser() != null)
                       ? new UserDTO(
                                todo.getUser().getId(),
                                todo.getUser().getUsername(),
                                todo.getUser().getEmail()
                        ) : null
                )).collect(Collectors.toList());
    }
  TodoDTO addTodo (Long id, TodoRequestDTO requestDTO) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Users not found"));
        Todo todo = new Todo();
        todo.setName(requestDTO.getName());
        todo.setDate(requestDTO.getDate());
        todo.setDescription(requestDTO.getDescription());
        todo.setUser(user);

        Todo saved = todoRepository.save(todo);
        return new TodoDTO(
                saved.getId(),
                saved.getName(),
                saved.getDate(),
                saved.getDescription(),
                new UserDTO(
                        saved.getUser().getId(),
                        saved.getUser().getUsername(),
                        saved.getUser().getEmail()
                )
        );
    }

    Todo updateTodo (Long id, Todo todo) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(id + " is not found!"));
        existingTodo.setName(todo.getName());
        existingTodo.setDate(todo.getDate());
        existingTodo.setDescription(todo.getDescription());
        return todoRepository.save(existingTodo);
    }

    void deleteTodo (Long id) {
        todoRepository.deleteById(id);
    }





}
