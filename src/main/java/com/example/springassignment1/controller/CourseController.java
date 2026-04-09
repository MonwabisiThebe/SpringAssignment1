package com.example.springassignment1.controller;

import com.example.springassignment1.Course;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private List<Course> courses = new ArrayList<>();

    @PostMapping
    public Course addCourse(@Valid @RequestBody Course course) {
        courses.add(course);
        return course;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courses;
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @Valid @RequestBody Course updatedCourse) {

        for (Course course : courses) {
            if (course.getId() == id) {
                course.setName(updatedCourse.getName());
                course.setCategory(updatedCourse.getCategory());
                return course;
            }
        }

        throw new RuntimeException("Course not found");
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {

        Iterator<Course> iterator = courses.iterator();

        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId() == id) {
                iterator.remove();
                return "Course deleted successfully";
            }
        }

        return "Course not found";
    }
}