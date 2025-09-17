package com.example.demo.TodoApp;


import com.example.demo.TodoApp.TodoDTOs.TodoDTO;
import com.example.demo.TodoApp.TodoDTOs.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UsersService {
    
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    List<UserDTO> getUsers() {
        return usersRepository.findAll()
                .stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getTodos().stream()
                                .map(todo -> new TodoDTO(
                                        todo.getId(),
                                        todo.getName(),
                                        todo.getDate(),
                                        todo.getDescription()
                                )).collect(Collectors.toList())
                )).collect(Collectors.toList());
    }
    List<UserDTO> getUser(Long id) {
        return usersRepository.findById(id).stream()
                .map(users -> new UserDTO(
                        users.getId(),
                        users.getUsername(),
                        users.getEmail()
                )).collect(Collectors.toList());
    }
    String addUser (Users user) {
        usersRepository.save(user);
        return user.getId() + " Added";
    }

    Users updateUser(Long id, Users user) {
        Users existingUser = usersRepository.findById(id)
                .orElseThrow(() ->new NoSuchElementException(id + " not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return usersRepository.save(existingUser);
    }

    String deleteUser(Long id) {
        usersRepository.deleteById(id);
        return "User deleted!";
    }

    
}
