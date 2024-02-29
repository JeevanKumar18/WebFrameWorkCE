package com.example.product_cw3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.product_cw3.model.Product;
import com.example.product_cw3.service.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProductController {

    private ProductService jobService;

    public ProductController(ProductService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/api/product")
    public ResponseEntity postMethodName(@RequestBody Product job) {

        Product p = jobService.saveProductDetail(job);
        return new ResponseEntity<>(p, HttpStatus.OK);

    }

    @GetMapping("/api/product")
    public List<Product> getAllDetail() {
        return jobService.getAllProducts();
    }

    @GetMapping("/api/product/{productId}")
    public Optional<Product> getDetailById(@PathVariable int productId) {
        return jobService.getProductById(productId);
    }
}
