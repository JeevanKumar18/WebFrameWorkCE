package com.example.demo.controller.Day2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.Day2Ex1;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ex1 {
    
    @Autowired
    private Day2Ex1 ac;
    @GetMapping("/path")
    public Day2Ex1 getAppDetails() {
        
        return ac;
    }
    
}



// package com.example.springapp.controller;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.springapp.model.Address;

// @RestController
// public class AddressController {
//     @RequestMapping("/address")
//     public Address getAddress()
//     {
//         Address a=new Address("nidharshan",123,"Main St",658865,"pudur","salem","tamil nadu","india");
//         return a;
//     }
// }
