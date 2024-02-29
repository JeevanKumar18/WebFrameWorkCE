package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.StudentInformation;

public interface StudentInformationRepo extends JpaRepository<StudentInformation,Integer>{
    
}
