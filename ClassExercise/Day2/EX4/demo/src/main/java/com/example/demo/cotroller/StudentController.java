package com.example.demo.cotroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
public class StudentController{

    @PostMapping("/post")
    public Student getDetails(@RequestBody Student entity){

        Student.id=entity.id;
        Student.name=entity.name;

        System.out.println(Student.id+" "+Student.name);
        return entity;

    }
    
}
