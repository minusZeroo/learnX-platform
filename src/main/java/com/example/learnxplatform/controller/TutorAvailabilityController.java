package com.example.learnxplatform.controller;

import com.example.learnxplatform.dto.TutorAvailabilityRequest;
import com.example.learnxplatform.entity.TutorAvailability;
import com.example.learnxplatform.service.TutorAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutor-availabilities") // Base URL for this controller
@CrossOrigin(origins = "http://localhost:3000") // Allowing cross-origin requests from localhost:3000
public class TutorAvailabilityController {

    @Autowired
    private TutorAvailabilityService tutorAvailabilityService; // Autowiring the service class


    // Endpoint to get all tutor availabilities
    @GetMapping
    public ResponseEntity<List<TutorAvailability>> getAllTutorAvailabilities() {
        List<TutorAvailability> tutorAvailabilities = tutorAvailabilityService.getAllTutorAvailabilities();
        return ResponseEntity.ok(tutorAvailabilities);
    }

    // Endpoint to create a new tutor availability
    @PostMapping
    public ResponseEntity<TutorAvailability> createTutorAvailability(@RequestBody TutorAvailabilityRequest request) {
        TutorAvailability createdAvailability = tutorAvailabilityService.createTutorAvailability(request);
        return new ResponseEntity<>(createdAvailability, HttpStatus.CREATED);
    }

    // Endpoint to get tutor availabilities by tutor ID
    @GetMapping("/by-tutor/{tutorId}")
    public ResponseEntity<List<TutorAvailability>> getTutorAvailabilityByTutor(@PathVariable Long tutorId) {
        List<TutorAvailability> tutorAvailabilities = tutorAvailabilityService.getTutorAvailabilityByTutor(tutorId);
        return ResponseEntity.ok(tutorAvailabilities);
    }

    // Endpoint to delete a tutor availability by request ID
    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteTutorAvailability(@PathVariable Long requestId) {
        tutorAvailabilityService.deleteTutorAvailability(requestId);
        return ResponseEntity.ok().build();
    }
}
