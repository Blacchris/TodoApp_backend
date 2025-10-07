package com.example.demo.TodoApp;


import com.example.demo.TodoApp.TodoDTOs.TodoResponseDTO;
import com.example.demo.TodoApp.TodoDTOs.UserRequestDTO;
import com.example.demo.TodoApp.TodoDTOs.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UsersService {
    
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public List<UserResponseDTO> getAllUsers() {
        return usersRepository.findAll()
                .stream()
                .map(this::fetchUsersWithTodos)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(Long id) {
        Users found = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found!"));
        return fetchUsersWithTodos(found);
    }

    public UserResponseDTO createUser (UserRequestDTO userRequestDTO) {
        Users newUser = new Users(
                userRequestDTO.getUsername(),
                userRequestDTO.getEmail(),
                userRequestDTO.getPassword()
        );
        return fetchUsersWithTodos(usersRepository.save(newUser));
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        Users found = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " Not Found!"));
        found.setUsername(userRequestDTO.getUsername());
        found.setEmail(userRequestDTO.getEmail());
        found.setPassword(userRequestDTO.getPassword());

        return fetchUsersWithTodos(usersRepository.save(found));
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }


    UserResponseDTO fetchUsersWithTodos (Users user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getTodos() != null ?
                        user.getTodos()
                                .stream()
                                .map(todo -> new TodoResponseDTO(
                                        todo.getId(),
                                        todo.getName(),
                                        todo.getDate(),
                                        todo.getDescription()
                                )).collect(Collectors.toList()) : null
        );
    }
}
