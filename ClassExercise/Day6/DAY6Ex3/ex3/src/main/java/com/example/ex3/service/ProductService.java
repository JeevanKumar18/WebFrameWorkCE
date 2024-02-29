package com.example.ex3.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ex3.model.Product;
import com.example.ex3.repository.ProductRepo;



@Service
public class ProductService {
    public ProductRepo productRepo;
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    
    public Product save(Product product)
    {
        return productRepo.save(product);
    }

    public List<Product> listing(int offset,int pagesize)
    {
        Page<Product> obj=productRepo.findAll(PageRequest.of(offset, pagesize));
        return obj.getContent();
    }

    public List<Product> paging(int offset,int pagesize,String field)
    {
        Page<Product> obj3 = productRepo.findAll(PageRequest.of(offset, pagesize,Sort.Direction.ASC,field));
        return obj3.getContent();
    }

    public Product getting(int product)
    {
        return productRepo.findById(product).orElse(null);
    }



}
