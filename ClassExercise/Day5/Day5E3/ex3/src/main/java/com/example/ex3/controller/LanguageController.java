package com.example.ex3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex3.model.Language;
import com.example.ex3.service.LanguageService;


@RestController
public class LanguageController {
    

    
   
        
    
        private LanguageService languageService;
        

        public LanguageController(LanguageService languageService) {
            this.languageService = languageService;
        }

        @PostMapping("/language")
        public ResponseEntity<Language>postProduct(@RequestBody Language productModel)
        {
            if(languageService.saveProduct(productModel)==true)
            {
                return new ResponseEntity<>(productModel,HttpStatus.CREATED);
            }
            return new ResponseEntity<>(productModel,HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    
        @GetMapping("/product/{id}")
        public ResponseEntity<Language> getProduct(@PathVariable("id") int id)
        {
            Language p=languageService.getProduct(id);
            if(p==null)
            {
                return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(p,HttpStatus.OK);
           
            
        }
    
        @GetMapping("/products")
        public ResponseEntity<List> getProducts()
        {
            List<Language>b=languageService.getAllProduct();
            if(b.size()==0)
            {
                return new ResponseEntity<>(b,HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
    
        @PutMapping("products/{id}")
        public ResponseEntity<Language> putMethodName(@PathVariable("id") int id, @RequestBody  Language productModel)
        {
            if(languageService.updateProduct(id,productModel)==true)
            {
                return new ResponseEntity<>(HttpStatus.OK);
                
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
        @DeleteMapping("products/{id}")
        public ResponseEntity<Language>delete(@PathVariable int id)
        {
            if(languageService.deleteProduct(id)==true)
            {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    
    
    }
    