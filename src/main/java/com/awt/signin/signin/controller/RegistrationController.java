package com.awt.signin.signin.controller;


import com.awt.signin.signin.entity.Users;
import com.awt.signin.signin.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegistrationController {

	@Autowired
	RegistrationRepo registrationRepo;

	@PostMapping("/Users")
	public String saveRegistration(@RequestBody Users usersData) {

		registrationRepo.save(usersData);
		return "Data Saved Successfully";
	}

	
}
