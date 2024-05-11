package com.example.learnxplatform.controller;

import com.example.learnxplatform.dto.TutorialRequestRequest;
import com.example.learnxplatform.entity.TutorialRequest;
import com.example.learnxplatform.service.TutorialRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorial-requests")
@CrossOrigin(origins = "http://localhost:3000")
public class TutorialRequestController {

    @Autowired
    private TutorialRequestService tutorialRequestService;

    @PostMapping
    public ResponseEntity<TutorialRequest> createTutorialRequest(@RequestBody TutorialRequestRequest request) {
        TutorialRequest createdRequest = tutorialRequestService.createTutorialRequest(request);
        return new ResponseEntity<>(createdRequest, HttpStatus.CREATED);
    }

    // Endpoint to set the status of a tutorial request
    @PutMapping("/{requestId}/status")
    public ResponseEntity<Void> setTutorialRequestStatus(@PathVariable Long requestId, @RequestParam String status) {
        tutorialRequestService.respondToTutorialRequest(requestId, status);
        return ResponseEntity.ok().build();
    }

    // Endpoint to get tutorial requests by student ID
    @GetMapping("/by-student/{studentId}")
    public ResponseEntity<List<TutorialRequest>> getTutorialRequestsByStudent(@PathVariable Long studentId) {
        List<TutorialRequest> tutorialRequests = tutorialRequestService.getTutorialRequestsByStudent(studentId);
        return ResponseEntity.ok(tutorialRequests);
    }

    // Endpoint to get tutorial requests by tutor ID
    @GetMapping("/by-tutor/{tutorId}")
    public ResponseEntity<List<TutorialRequest>> getTutorialRequestsByTutor(@PathVariable Long tutorId) {
        List<TutorialRequest> tutorialRequests = tutorialRequestService.getTutorialRequestsByTutor(tutorId);
        return ResponseEntity.ok(tutorialRequests);
    }

    // Endpoint to get all tutorial requests
    @GetMapping
    public ResponseEntity<List<TutorialRequest>> getAllTutorialRequests() {
        List<TutorialRequest> tutorialRequests = tutorialRequestService.getAllTutorialRequests();
        return ResponseEntity.ok(tutorialRequests);
    }

    // Endpoint to get tutorial requests by status
    @GetMapping("/by-status/{status}")
    public ResponseEntity<List<TutorialRequest>> getTutorialRequestsByStatus(@PathVariable String status) {
        List<TutorialRequest> tutorialRequests = tutorialRequestService.getTutorialRequestsByStatus(status);
        return ResponseEntity.ok(tutorialRequests);
    }

    // Endpoint to delete a tutorial request by request ID
    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteTutorialRequest(@PathVariable Long requestId) {
        tutorialRequestService.deleteTutorialRequest(requestId);
        return ResponseEntity.ok().build();
    }
}
