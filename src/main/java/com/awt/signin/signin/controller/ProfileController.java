package com.awt.signin.signin.controller;

import com.awt.signin.signin.entity.Registration;
import com.awt.signin.signin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    RegistrationRepository registrationRepository;

    @GetMapping("/profile")
    public List<Registration> getProfileDetails() {

        return registrationRepository.findAll();
    }
}
