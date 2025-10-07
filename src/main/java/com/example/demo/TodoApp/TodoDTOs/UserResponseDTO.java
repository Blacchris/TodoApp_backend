package com.example.demo.TodoApp.TodoDTOs;

import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private List<TodoResponseDTO> todoResponseDTOS;

    public UserResponseDTO(Long id, String username, String email, List<TodoResponseDTO> todoResponseDTOS) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.todoResponseDTOS = todoResponseDTOS;
    }

    public UserResponseDTO(Long id, String username, String email) {
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

    public List<TodoResponseDTO> getTodoDTOs() {
        return todoResponseDTOS;
    }

    public void setTodoDTOs(List<TodoResponseDTO> todoResponseDTOS) {
        this.todoResponseDTOS = todoResponseDTOS;
    }
}
