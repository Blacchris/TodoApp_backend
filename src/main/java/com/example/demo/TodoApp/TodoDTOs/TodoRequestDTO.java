package com.example.demo.TodoApp.TodoDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TodoRequestDTO {

    @NotBlank(message = "Todo name is required")
    @Size(max = 100, message = "Todo name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    public TodoRequestDTO () {};
    public TodoRequestDTO(String name, String date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
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
}
