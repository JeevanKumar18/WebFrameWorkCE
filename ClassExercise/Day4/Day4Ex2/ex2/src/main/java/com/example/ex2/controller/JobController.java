package com.example.ex2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex2.model.Job;
import com.example.ex2.service.JobService;

@RestController
public class JobController {
    
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @PostMapping("/api/job")
    public ResponseEntity postMethodName(@RequestBody List<Job> job) {

        if(jobService.savaJov(job) == true){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/api/job")
    public List<Job> getAllDetail() {
        return jobService.getAllJob();
    }


    @GetMapping("/api/job/{jobId}")
    public Optional<Job> getDetailById(@PathVariable int jobId) {
        return jobService.getJobById(jobId);
    }
    
}
