package com.example.demo.TodoApp.TodoDTOs;

public class TodoResponseDTO {

    private Long id;
    private String name;
    private String date;
    private String description;
    private UserResponseDTO userResponseDTO;

    public TodoResponseDTO() {};

    public TodoResponseDTO(Long id, String name, String date, String description, UserResponseDTO userResponseDTO) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.userResponseDTO = userResponseDTO;
    }

    public TodoResponseDTO(Long id, String name, String date, String description) {
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


    public UserResponseDTO getUserDTO() {
        return userResponseDTO;
    }

    public void setUserDTO(UserResponseDTO userResponseDTO) {
        this.userResponseDTO = userResponseDTO;
    }
}
