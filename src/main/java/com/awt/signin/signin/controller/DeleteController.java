package com.awt.signin.signin.controller;

import com.awt.signin.signin.entity.Registration;
import com.awt.signin.signin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DeleteController {

    @Autowired
    RegistrationRepository registrationRepository;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        Optional<Registration> repositoryById = registrationRepository.findById(id);

        if (repositoryById.isPresent()) {
            registrationRepository.deleteById(id);
            return ResponseEntity.ok("Profile with ID " + id + " is deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profile with ID " + id + " not found");
        }
    }

}
