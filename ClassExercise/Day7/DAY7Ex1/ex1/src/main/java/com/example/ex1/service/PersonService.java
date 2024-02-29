package com.example.ex1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex1.model.Person;
import com.example.ex1.repository.PersonRepo;

@Service
public class PersonService {
    

    private PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }
    
    public boolean savePerson(Person person)
    {
        try{
            personRepo.save(person);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public List<Person> getAll()
    {
        return personRepo.findAll();
    }

    public List<Person> getByAge(int byAge)
    {
        return personRepo.findByAge(byAge);
    }
}
