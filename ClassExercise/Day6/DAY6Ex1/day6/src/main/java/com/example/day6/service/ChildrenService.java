package com.example.day6.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6.model.Children;
import com.example.day6.repository.ChildrenRepo;


@Service
public class ChildrenService {
    
    ChildrenRepo childrenRepo;


    @Autowired
    public ChildrenService(ChildrenRepo childrenRepo) {
        this.childrenRepo = childrenRepo;
    }
    public ChildrenService() {
        
    }

    public boolean saveProduct(Children children)
    {
        try{

         childrenRepo.save(children);
         
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public Optional<Children> getbyId(Integer childId)
    {
        return childrenRepo.findById(childId);
    }
    public List<Children>getAllChildren()
    {
        return childrenRepo.findAll();
    }

    public Page<Children> childPage(int offset , int pageSize , String field)
    {
        return childrenRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
    }

    public List<Children> childSortList(String field)
    {
        return childrenRepo.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    public Page<Children> pagination(int offSet,int pageSize)
    {
        return childrenRepo.findAll(PageRequest.of(offSet, pageSize));
    }






    


}
