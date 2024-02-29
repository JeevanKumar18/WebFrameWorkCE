package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepo;

@RestController
public class SchoolController {
    

    @Autowired
    private SchoolRepo schoolRepo;

    @PostMapping("/post")
    public School postSchool(@RequestBody School school)
    {
        return schoolRepo.save(school);
    }

    @GetMapping("/get")
    public List<School>getAllSchool()
    {
        return schoolRepo.findAll();
    }
}
