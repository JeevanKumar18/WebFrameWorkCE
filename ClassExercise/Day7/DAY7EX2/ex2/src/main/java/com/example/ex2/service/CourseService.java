package com.example.ex2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex2.model.Course;
import com.example.ex2.repository.CourseRepo;


@Service
public class CourseService {
    

    private CourseRepo courseRepo;

    
    

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public boolean savePerson(Course course)
    {
        try{
            courseRepo.save(course);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public List<Course> getAll()
    {
        return courseRepo.findAll();
    }

    public List<Course> getByName(String courseName)
    {
        return courseRepo.findByCourseNameLike(courseName);
    }
}
