package com.example.product_cw3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;

import com.example.product_cw3.model.Product;
import com.example.product_cw3.repository.ProductRopo;


@Service
public class ProductService {
    

    private ProductRopo productRopo;

    public ProductService(ProductRopo jobRopo) {
        this.productRopo = jobRopo;
    }

    public Product saveProductDetail(Product product){

        return productRopo.save(product);
    }


    public List<Product> getAllProducts(){
        return productRopo.findAll();
    }

    public Optional<Product> getProductById(int id){

        return productRopo.findById(id);
    }
}