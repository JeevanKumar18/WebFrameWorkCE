package com.example.ex2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ex2.model.Employee;
import com.example.ex2.service.EmployeeService;

public class EmployeeController {
    
     private EmployeeService employeeService;
     
    



    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/product")
    public ResponseEntity<Employee>postProduct(@RequestBody Employee productModel)
    {
        if(employeeService.saveProduct(productModel)==true)
        {
            return new ResponseEntity<>(productModel,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(productModel,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Employee> getProduct(@PathVariable("id") int id)
    {
        Employee p=employeeService.getProduct(id);
        if(p==null)
        {
            return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
       
        
    }

    @GetMapping("/products")
    public ResponseEntity<List> getProducts()
    {
        List<Employee>b=employeeService.getAllProduct();
        if(b.size()==0)
        {
            return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b,HttpStatus.OK);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Employee> putMethodName(@PathVariable("id") int id, @RequestBody  Employee productModel)
    {
        if(employeeService.updateProduct(id,productModel)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
            
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Employee>delete(@PathVariable int id)
    {
        if(employeeService.deleteProduct(id)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
