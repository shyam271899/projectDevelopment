package com.awt.signin.signin.controller;

import com.awt.signin.signin.entity.LoginRequest;
import com.awt.signin.signin.entity.Users;
import com.awt.signin.signin.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegitrationController {

    @Autowired
    RegistrationRepo registrationRepo;


    @PostMapping("/Users")
    public String saveRegistration(@RequestBody Users usersData) {

        registrationRepo.save(usersData);
        return "Data Saved Successfully";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        String email = loginRequest.getEmail();
        String password =loginRequest.getPassword();

        Users user=registrationRepo.findByEmail(email);


        if (email == null || !email.equals(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email");
        }
        if (password == null || !password.equals(user.getPassword())) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");


        }
        return ResponseEntity.ok("Login successful");

    }
}
