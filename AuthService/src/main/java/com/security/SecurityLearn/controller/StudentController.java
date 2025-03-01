package com.security.SecurityLearn.controller;

import com.security.SecurityLearn.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "John", "Computer Science"));
        students.add(new Student(2, "Jane", "Mathematics"));
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to the home page";
    }

    @GetMapping("/student")
    public List<Student> student() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrf(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/student")
    public Student registerNewStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
