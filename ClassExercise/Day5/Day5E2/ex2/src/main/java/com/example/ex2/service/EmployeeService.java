package com.example.ex2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex2.model.Employee;
import com.example.ex2.repository.EmployeeRepo;

@Service
public class EmployeeService {
    
    private EmployeeRepo employeeRepo;
    

    public EmployeeService(EmployeeRepo productRepo) {
        this.employeeRepo = productRepo;
    }
    public boolean saveProduct(Employee productModel)
    {
        try {
                employeeRepo.save(productModel);
            
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }
    public Employee getProduct(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
   

    public List<Employee>getAllProduct()
    {
        return employeeRepo.findAll();
    }

    public boolean updateProduct(int id,Employee productModel)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    employeeRepo.save(productModel);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }

    public boolean deleteProduct(int id)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    employeeRepo.deleteById(id);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
    }
}
