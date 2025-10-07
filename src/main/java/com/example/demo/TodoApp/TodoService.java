package com.example.demo.TodoApp;

import com.example.demo.TodoApp.TodoDTOs.TodoRequestDTO;
import com.example.demo.TodoApp.TodoDTOs.TodoResponseDTO;
import com.example.demo.TodoApp.TodoDTOs.UserRequestDTO;
import com.example.demo.TodoApp.TodoDTOs.UserResponseDTO;
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

    public List<TodoResponseDTO> getAllTodos () {
        return todoRepository.findAll()
                .stream()
                .map(this::fetchAllTodosWithUser)
                .collect(Collectors.toList());
    }

    public TodoResponseDTO getTodoById (Long id) {
        Todo found = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found!"));
        return fetchAllTodosWithUser(found);
    }

//    public TodoResponseDTO getTodoByUserId (Long id) {
//        Users user = usersRepository.findById(id)
//                .orElseThrow(() -> new IllegalStateException(id + " not found!"));
//
//
//    }

    public TodoResponseDTO createTodo (Long id, TodoRequestDTO todoRequestDTO) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found!"));
        return fetchAllTodosWithUser(
                todoRepository.save(
                        new Todo(
                                todoRequestDTO.getName(),
                                todoRequestDTO.getDate(),
                                todoRequestDTO.getDescription(),
                                user
                        )
                )
        );
    }

    public TodoResponseDTO updateTodo (Long id, TodoRequestDTO todoRequestDTO) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Todo with id: " + id + " not found!"));
        todo.setName(todoRequestDTO.getName());
        todo.setDate(todoRequestDTO.getDate());
        todo.setDescription(todoRequestDTO.getDescription());

        return fetchAllTodosWithUser(todoRepository.save(todo));
    }

    public void deleteTodoById (Long id) {
        todoRepository.deleteById(id);
    }

    public TodoResponseDTO fetchAllTodosWithUser (Todo todo) {
        return new TodoResponseDTO(
                todo.getId(),
                todo.getName(),
                todo.getDate(),
                todo.getDescription(),
                new UserResponseDTO(
                        todo.getUser().getId(),
                        todo.getUser().getUsername(),
                        todo.getUser().getEmail()
                )
        );
    }



}
