package com.example.ex1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex1.model.Person;
import com.example.ex1.service.PersonService;

@RestController
public class PersonController {
    

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping("/api/person")
    public ResponseEntity<Person> post(@RequestBody Person person)
    {
        if(personService.savePerson(person)==true)
        {
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(person,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/person")
    public List<Person>getAllPerson()
    {
        return personService.getAll();
    }

    @GetMapping("/api/person/byAge")
    public ResponseEntity<List<Person>> getAllByAge(@RequestParam int byAge)
    {
        List<Person> p=personService.getByAge(byAge);
        if(p==null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }


}
