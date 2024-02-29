package com.example.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.products.model.ProductModel;


@Repository
public interface ProductRepo extends JpaRepository<ProductModel,Integer>
{
    
}
