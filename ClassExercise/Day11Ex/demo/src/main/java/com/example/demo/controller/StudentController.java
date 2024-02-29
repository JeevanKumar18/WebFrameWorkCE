package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.StudentInformation;
import com.example.demo.repository.StudentInformationRepo;
import com.example.demo.repository.StudentRepo;

@RestController
public class StudentController {
    
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentInformationRepo studentInformationRepo;

    @PostMapping("/post")
    public Student create(@RequestBody Student student)
    {
        return studentRepo.save(student);
    }
    @PostMapping("/info/post")
    public StudentInformation create(@RequestBody StudentInformation studentInformation)
    {
        return studentInformationRepo.save(studentInformation);
    }

    @GetMapping("/students")
    public List<Student>findAllStudent()
    {
        return studentRepo.findAll();
    }
    @GetMapping("/info/students")
    public List<StudentInformation>findAllStudent1()
    {
        return studentInformationRepo.findAll();
    }
}
