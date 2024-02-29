package com.example.demo.controller.Day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.Day2Ex1;

@RestController
public class ex3 {
    @Autowired
    private Day2Ex1 ac;
    @GetMapping("/pa")
    public Day2Ex1 getAppDetails() {
        
        return ac;
    }
}
