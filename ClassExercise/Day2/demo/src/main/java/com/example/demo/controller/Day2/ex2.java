package com.example.demo.controller.Day2;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Day2Ex2;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ex2 {
    

    @PostMapping("/post")
    public Day2Ex2 postMethodName(@RequestBody Day2Ex2 entity) {
     
        Day2Ex2.id=entity.id;
        Day2Ex2.name=entity.name;
        System.out.println(Day2Ex2.id+" "+Day2Ex2.name);
        return entity;
    }
    
    
}
