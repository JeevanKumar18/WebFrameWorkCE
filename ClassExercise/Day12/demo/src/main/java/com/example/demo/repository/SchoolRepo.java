package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.School;

public interface SchoolRepo extends JpaRepository<School,Integer>{
    
}
