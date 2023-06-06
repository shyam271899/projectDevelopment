package com.awt.signin.signin.controller;


import com.awt.signin.signin.entity.Registration;
import com.awt.signin.signin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegistrationController {

    @Autowired
    RegistrationRepository registrationRepo;

    @PostMapping("/Users")
    public String saveRegistration(@RequestBody Registration usersData) {

        Registration byEmail = registrationRepo.findByEmail(usersData.getEmail());

        if (byEmail == null) {
            registrationRepo.save(usersData);
            return "Data Saved Successfully";
        } else {
            return "Email already exists";
        }
    }


}
