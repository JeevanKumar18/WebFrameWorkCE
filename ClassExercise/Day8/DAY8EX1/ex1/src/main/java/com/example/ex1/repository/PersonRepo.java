package com.example.ex1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ex1.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person,Long>{
    

    List<Person>findByNameStartingWith(char c);

    List<Person>findByNameEndingWith(char c);
}
