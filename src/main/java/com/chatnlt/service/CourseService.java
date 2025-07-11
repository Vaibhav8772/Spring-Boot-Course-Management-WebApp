package com.chatnlt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatnlt.entities.Course;
import com.chatnlt.repository.CourseRepository;

@Service
public class CourseService {

	
	 @Autowired
	    private CourseRepository courseRepo;

	    public List<Course> getAllCourses() {
	        return courseRepo.findAll();
	    }

	    public Course getCourse(Long id) {
	        return courseRepo.findById(id).orElse(null);
	    }
	    
	    
	    public Course addCourse(Course course) {
	        return courseRepo.save(course);
	    }
}
