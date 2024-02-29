package com.example.product_cw3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_cw3.model.Product;



public interface ProductRopo extends JpaRepository<Product,Integer> {

    
}