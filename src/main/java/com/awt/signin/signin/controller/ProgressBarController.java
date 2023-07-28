/*
package com.awt.signin.signin.controller;
 */

/*
import com.awt.signin.signin.entity.ProgressBar;
import com.awt.signin.signin.entity.Registration;
import com.awt.signin.signin.repository.ProgressBarRepository;
import com.awt.signin.signin.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProgressBarController {


     RegistrationRepository registrationRepository;

     ProgressBarRepository progressBarRepository;


    @Autowired
    public ProgressBarController(RegistrationRepository registrationRepository,ProgressBarRepository progressBarRepository) {
        this.registrationRepository = registrationRepository;
        this.progressBarRepository = progressBarRepository;
    }



    @GetMapping("/progress")
    public List<ProgressBar> getProgress() {
        return progressBarRepository.findAll();
    }

    @GetMapping("/progress/{id}")
    public ResponseEntity<?> getProgress(@PathVariable Long id) {
        Optional<ProgressBar> optionalProgress = progressBarRepository.findById(id);

        if (optionalProgress.isPresent()) {
            ProgressBar progress = optionalProgress.get();
            return ResponseEntity.ok(progress);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Progress with ID " + id + " not found");
        }
    }



    @PostMapping("/updateProgress")
    public ResponseEntity<String> updateProgress(@RequestBody ProgressBar progress) {
        Optional<Registration> optionalCourses = registrationRepository.findById(progress.getId());

        if (optionalCourses.isPresent()) {

            Registration existingRequest = optionalCourses.get();

            if (existingRequest.getProgress() == (progress.getNewProgress())) {
                return ResponseEntity.badRequest().body("Invalid  progress!!");
            }
            else if (progress.getNewProgress() == (progress.getOldProgress())) {
                return ResponseEntity.badRequest().body("Same old and new Progress");
            }else {
                existingRequest.setProgress(progress.getNewProgress());
                registrationRepository.save(existingRequest);


                return ResponseEntity.ok("Progress saved successfully");
            }

        }
        else {
            return ResponseEntity.ok("Registration Not Found");
        }
    }
}

*/