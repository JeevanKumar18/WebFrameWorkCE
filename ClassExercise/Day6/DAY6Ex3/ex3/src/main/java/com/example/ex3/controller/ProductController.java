package com.example.ex3.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex3.model.Product;
import com.example.ex3.service.ProductService;


@RestController
public class ProductController {
    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @PostMapping("/api/product")
    public ResponseEntity<Product> post(@RequestBody Product product)
    {
        Product obj=productService.save(product);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Product>> pagesort(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        List<Product> object=productService.paging(offset, pagesize, field);
        return new ResponseEntity<>(object,HttpStatus.OK);
    }


    @GetMapping("/api/product/{offset}/{pagesize}")
    public ResponseEntity<List<Product>> paging(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize)
    {
        List<Product> obj2= productService.listing(offset,pagesize);
        return new ResponseEntity<>(obj2,HttpStatus.OK);
    }

    @GetMapping("/api/product/{id}")
    public ResponseEntity<Product> getting(@PathVariable int id)
    {
        Product obj5 = productService.getting(id);
        if(obj5==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(obj5,HttpStatus.OK);
    }
}