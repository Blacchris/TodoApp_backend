package com.example.demo.TodoApp.TodoDTOs;

import com.example.demo.TodoApp.Todo;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private List<TodoDTO> todoDTOs;

    public UserDTO(Long id, String username, String email, List<TodoDTO> todoDTOs) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.todoDTOs = todoDTOs;
    }

    public UserDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TodoDTO> getTodoDTOs() {
        return todoDTOs;
    }

    public void setTodoDTOs(List<TodoDTO> todoDTOs) {
        this.todoDTOs = todoDTOs;
    }
}
