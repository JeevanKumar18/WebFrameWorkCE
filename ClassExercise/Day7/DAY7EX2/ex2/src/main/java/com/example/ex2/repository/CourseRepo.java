package com.example.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex2.model.Course;
import java.util.List;


public interface CourseRepo extends JpaRepository<Course,Integer>{

    List<Course> findByCourseNameLike(String courseName);
    
}
