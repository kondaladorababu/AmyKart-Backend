package com.security.amyKart.controller;

import com.security.amyKart.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "John", "Computer Science"));
        students.add(new Student(2, "Jane", "Mathematics"));
    }

    @GetMapping("/welcome")
    public String home() {
        return "Welcome to the home page";
    }

    @GetMapping
    public List<Student> student() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken csrf(HttpServletRequest request) {
        System.out.println("CSRF token: " + request.getHeader("X-CSRF-TOKEN"));
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping
    public Student registerNewStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
