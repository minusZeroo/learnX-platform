package com.example.learnxplatform.controller;

import com.example.learnxplatform.dto.TutorialRequestRequest;
import com.example.learnxplatform.entity.TutorialRequest;
import com.example.learnxplatform.service.TutorialRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
