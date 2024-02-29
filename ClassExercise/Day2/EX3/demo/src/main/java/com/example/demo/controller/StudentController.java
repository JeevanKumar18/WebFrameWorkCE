package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class StudentController {
    @GetMapping("/ignore")
    public Student ac()
    {
        Student s=new Student(72, "Jeevan", "jhefbyudbgi");
        return s;
    }
    
    }
    

