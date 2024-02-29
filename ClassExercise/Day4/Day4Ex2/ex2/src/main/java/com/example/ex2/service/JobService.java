package com.example.ex2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ex2.model.Job;
import com.example.ex2.repository.JobRepo;

@Service
public class JobService {
    
    private JobRepo jobRepo;

    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public boolean savaJov(List<Job> job){

        try{
            jobRepo.saveAll(job);
            
        }
        catch(Exception e){

            System.out.println(" \n exception \n");
            System.out.println(e.getMessage());
            System.out.println(" \n exception \n");

            return false;
        }

        return true;
    }

    public List<Job> getAllJob(){

        return jobRepo.findAll();
    }

    public Optional<Job> getJobById(int id){
        return jobRepo.findById(id);
    }




}
