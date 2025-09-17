package com.example.demo.TodoApp;

import com.example.demo.TodoApp.TodoDTOs.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin(originPatterns = "*")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    List<UserDTO> getUsers() {
        return usersService.getUsers();
    }
    @GetMapping("/{id}")
    List<UserDTO> getUser (@PathVariable Long id) {
        return usersService.getUser(id);
    }
    @PostMapping
    String addUser(@RequestBody Users user) {
        return usersService.addUser(user);
    }
    @PutMapping("/{id}")
    Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return usersService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable Long id) {
        return usersService.deleteUser(id);
    }





}
