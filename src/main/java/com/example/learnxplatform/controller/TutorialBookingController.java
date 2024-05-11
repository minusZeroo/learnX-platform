package com.example.learnxplatform.controller;

import com.example.learnxplatform.dto.TutorialBookingRequest;
import com.example.learnxplatform.entity.TutorialBooking;
import com.example.learnxplatform.service.TutorialBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tutorial-bookings")
@CrossOrigin(origins = "http://localhost:3000")
public class TutorialBookingController {

    @Autowired
    private TutorialBookingService tutorialBookingService;

    @PostMapping
    public ResponseEntity<TutorialBooking> createTutorialBooking(@RequestBody TutorialBookingRequest request) {
        TutorialBooking createdBooking = tutorialBookingService.bookTutorial(request);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }
}
