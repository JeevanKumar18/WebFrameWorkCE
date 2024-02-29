package com.example.ex2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ex2.model.Student;
import com.example.ex2.repository.StudentRepo;

@Service
public class StudentService {
    

    private StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    

     public boolean save(Student student)
    {
        try{

         studentRepo.save(student);
         
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

   

    public Page<Student> childPage(int offset , int pageSize , String field)
    {
        return studentRepo.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
    }

    public Page<Student> pagination(int offSet,int pageSize)
    {
        return studentRepo.findAll(PageRequest.of(offSet, pageSize));
    }

    
}
