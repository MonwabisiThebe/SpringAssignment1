package com.example.springassignment1;

import jakarta.validation.constraints.NotBlank;

public class Course {

    private int id;

    @NotBlank(message = "Course name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    public Course() {}

    public Course(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}