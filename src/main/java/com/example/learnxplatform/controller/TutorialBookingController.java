package com.example.learnxplatform.controller;

import com.example.learnxplatform.dto.TutorialBookingRequest;
import com.example.learnxplatform.entity.TutorialBooking;
import com.example.learnxplatform.service.TutorialBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorial-bookings") // Base URL for this controller
@CrossOrigin(origins = "http://localhost:3000") // Allowing cross-origin requests from localhost:3000
public class TutorialBookingController {

    @Autowired
    private TutorialBookingService tutorialBookingService; // Autowiring the service class

    // Endpoint to create a new tutorial booking
    @PostMapping
    public ResponseEntity<TutorialBooking> createTutorialBooking(@RequestBody TutorialBookingRequest request) {
        TutorialBooking createdBooking = tutorialBookingService.bookTutorial(request);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    // Endpoint to get tutorial bookings by student ID
    @GetMapping("/by-student/{studentId}")
    public ResponseEntity<List<TutorialBooking>> getTutorialBookingsByStudent(@PathVariable Long studentId) {
        List<TutorialBooking> tutorialBookings = tutorialBookingService.getTutorialBookingByStudent(studentId);
        return ResponseEntity.ok(tutorialBookings);
    }

    // Endpoint to get tutorial bookings by tutor ID
    @GetMapping("/by-tutor/{tutorId}")
    public ResponseEntity<List<TutorialBooking>> getTutorialBookingsByTutor(@PathVariable Long tutorId) {
        List<TutorialBooking> tutorialBookings = tutorialBookingService.getTutorialBookingByTutor(tutorId);
        return ResponseEntity.ok(tutorialBookings);
    }

    // Endpoint to get all tutorial bookings
    @GetMapping
    public ResponseEntity<List<TutorialBooking>> getAllTutorialBookings() {
        List<TutorialBooking> tutorialBookings = tutorialBookingService.getAllTutorialBookings();
        return ResponseEntity.ok(tutorialBookings);
    }

    // Endpoint to delete a tutorial booking by request ID
    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteTutorialBooking(@PathVariable Long requestId) {
        tutorialBookingService.deleteTutorialBooking(requestId);
        return ResponseEntity.ok().build();
    }
}
