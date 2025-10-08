package com.example.demo.TodoApp;


import com.example.demo.TodoApp.TodoDTOs.UserRequestDTO;
import com.example.demo.TodoApp.TodoDTOs.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin(originPatterns = "*")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers () {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponseDTO> getUserById (@PathVariable Long id) {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser (@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO created = usersService.createUser(userRequestDTO);
        return ResponseEntity.created(URI.create("/api" + created.getId()))
                .body(created);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserResponseDTO> updateUser (@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(usersService.updateUser(id, userRequestDTO));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUserById (@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }






}