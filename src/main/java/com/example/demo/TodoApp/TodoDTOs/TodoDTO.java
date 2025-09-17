package com.example.demo.TodoApp.TodoDTOs;

import com.example.demo.TodoApp.Users;

public class TodoDTO {

    private Long id;
    private String name;
    private String date;
    private String description;
    private UserDTO userDTO;

    public TodoDTO () {};

    public TodoDTO(Long id, String name, String date, String description, UserDTO userDTO) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.userDTO = userDTO;
    }

    public TodoDTO(Long id, String name, String date, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
