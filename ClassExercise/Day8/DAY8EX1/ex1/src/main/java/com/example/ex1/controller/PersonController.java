package com.example.ex1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex1.model.Person;
import com.example.ex1.service.PersonService;

@RestController
public class PersonController {
    
    
    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Person> post(@RequestBody  Person person) {
        if (personService.post(person)) {
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/person/start/{mark}")
    public ResponseEntity<List<Person>> getAll(@PathVariable char mark) {
        List<Person> li = personService.start(mark);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person/end/{mark}")
    public ResponseEntity<List<Person>> getbyAge(@PathVariable char mark) {
        List<Person> li = personService.end(mark);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
