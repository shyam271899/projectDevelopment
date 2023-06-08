package com.awt.signin.signin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Courses {
	
	@Id
	private Long course_id;
	
	private String courseName;


}
