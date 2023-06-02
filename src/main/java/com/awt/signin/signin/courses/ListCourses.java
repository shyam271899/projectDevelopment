package com.awt.signin.signin.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Repository
@RestController
public class ListCourses {
	
	@Autowired
	CoursesRepo courserepo;
	
	@GetMapping("/courses")
	public List<Course_list> getAllCourses()
	{
		return courserepo.findAll();
		
	}

}
