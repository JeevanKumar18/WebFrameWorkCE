package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@RestController
public class StudentController {
    

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/st/post")
    public Student posStudent(@RequestBody Student student)
    {
        return studentRepo.save(student);
    }

     @GetMapping("/st/get")
    public List<Student>getAllSchool()
    {
        return studentRepo.findAll();
    }
}
