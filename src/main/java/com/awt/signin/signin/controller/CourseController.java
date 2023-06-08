package com.awt.signin.signin.controller;

import java.util.List;


import com.awt.signin.signin.entity.Courses;
import com.awt.signin.signin.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CourseController {
	
	@Autowired
	CoursesRepository courserepo;
	
	@GetMapping("/courses")
	public List<Courses> getAllCourses()
	{
		return courserepo.findAll();
		
	}

}
