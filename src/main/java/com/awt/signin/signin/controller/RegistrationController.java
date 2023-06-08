package com.awt.signin.signin.controller;


import com.awt.signin.signin.entity.Registration;
import com.awt.signin.signin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegistrationController {

    @Autowired
    RegistrationRepository registrationRepository;

    @PostMapping("/Users")
    public ResponseEntity<?> saveRegistration(@RequestBody Registration usersData) {

        Registration byEmail = registrationRepository.findByEmail(usersData.getEmail());

        if (byEmail == null) {
            registrationRepository.save(usersData);
            return ResponseEntity.ok("Data Saved Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }
    }


}
