package com.example.ex1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex1.model.Person;
import com.example.ex1.repository.PersonRepo;


@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    public boolean post(Person person) {
        try {
            personRepo.save(person);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Person> start(char c) {
        return personRepo.findByNameStartingWith(c);
    }

    public List<Person> end(char c) {
        return personRepo.findByNameEndingWith(c);
    }
}
