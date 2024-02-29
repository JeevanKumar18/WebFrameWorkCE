package com.example.products.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.products.model.ProductModel;
import com.example.products.repository.ProductRepo;

@Service
public class ProductService {
    

    private ProductRepo productRepo;
    

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(ProductModel productModel)
    {
        try {
                productRepo.save(productModel);
            
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }
    public ProductModel getProduct(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
   

    public List<ProductModel>getAllProduct()
    {
        return productRepo.findAll();
    }

    public boolean updateProduct(int id,ProductModel productModel)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    productRepo.save(productModel);
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
                    productRepo.deleteById(id);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
    }

}
