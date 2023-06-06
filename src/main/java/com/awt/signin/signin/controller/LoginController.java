package com.awt.signin.signin.controller;

import com.awt.signin.signin.entity.Login;
import com.awt.signin.signin.entity.Registration;
import com.awt.signin.signin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    RegistrationRepository registrationRepo;


    @PostMapping("/log")
    public ResponseEntity<Registration> login(@RequestBody Login login) {
        String email = login.getEmail();
        String password = login.getPassword();
        try {
            Registration registration = registrationRepo.findByEmail(email);
            if (registration == null || !email.equals(registration.getEmail())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Registration("Invalid Email"));
            } else if (password == null || !password.equals(registration.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Registration("Invalid Password"));
            } else {
                registration.setMessage("Login Success");
                return ResponseEntity.ok(registration);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Registration("An error occurred"));
    }


}