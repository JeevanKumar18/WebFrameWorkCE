package com.example.ex3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex3.model.Language;
import com.example.ex3.repository.LanguageRepo;




@Service
public class LanguageService {
    

   private LanguageRepo languageRepo;

public LanguageService(LanguageRepo languageRepo) {
    this.languageRepo = languageRepo;
}

public boolean saveProduct(Language productModel)
    {
        try {
                languageRepo.save(productModel);
            
            } 
            catch (Exception e) {
               return false;
            }
            return true;
        
    }
    public Language getProduct(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }
   

    public List<Language>getAllProduct()
    {
        return languageRepo.findAll();
    }

    public boolean updateProduct(int id,Language productModel)
    {
        if(this.getProduct(id)==null)
        {
            return false;
        }
        try {
                    languageRepo.save(productModel);
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
                    languageRepo.deleteById(id);
            } 
            catch (Exception e) {
               return false;
            }
            return true;
    }

   


}
