package com.example.ex2.controller;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex2.model.Student;
import com.example.ex2.service.StudentService;

@RestController
public class StudentController {
    

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

     @PostMapping("/api/student")
    public ResponseEntity<Student>postProduct(@RequestBody Student student)
    {
        if(studentService.save(student) == true)
        {
            return new ResponseEntity<>(student,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(student,HttpStatus.INTERNAL_SERVER_ERROR);
    }

     @GetMapping("/api/student")
    public Page<Student> pageChild(@PathVariable int offset ,@PathVariable int pageSize)
    {
        return studentService.pagination(offset, pageSize);
    }

    @GetMapping("/api/student/sort")
    public Page<Student> getMethodName(@RequestParam int offset ,@RequestParam int pageSize ,@PathVariable String field) {
        return studentService.childPage(offset, pageSize, field);

    
}
}
