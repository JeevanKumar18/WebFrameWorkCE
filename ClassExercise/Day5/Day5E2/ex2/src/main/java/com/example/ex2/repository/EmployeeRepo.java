package com.example.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex2.model.Employee;

public interface  EmployeeRepo extends JpaRepository<Employee,Integer>
{
    
}
