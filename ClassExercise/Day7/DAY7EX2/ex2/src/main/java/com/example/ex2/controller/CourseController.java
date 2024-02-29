package com.example.ex2.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.ex2.model.Course;
import com.example.ex2.service.CourseService;

@RestController
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @PostMapping("/api/course")
    public ResponseEntity<Course> post(@RequestBody Course course)
    {
        if(courseService.savePerson(course)==true)
        {
            return new ResponseEntity<>(course,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(course,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/course")
    public List<Course>getAllCourse()
    {
        return courseService.getAll();
    }

    @GetMapping("/api/course/{courseName}")
    public ResponseEntity<List<Course>> getAllByAge(@PathVariable("courseName") String courseName )
    {
        List<Course> p=courseService.getByName(courseName);
        if(p==null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
   
}
