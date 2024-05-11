package com.example.learnxplatform.service;


import com.example.learnxplatform.dto.TutorialRequestRequest;
import com.example.learnxplatform.entity.TutorialRequest;
import com.example.learnxplatform.repository.TutorialRequestRepository;
import com.example.learnxplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialRequestService {

    @Autowired
    private TutorialRequestRepository tutorialRequestRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TutorialRequest> getTutorialRequestsForTutor(Long tutorId) {
        return tutorialRequestRepository.findByTutorId(tutorId);
    }

    public void respondToTutorialRequest(Long requestId, String response) {
        TutorialRequest tutorialRequest = tutorialRequestRepository.getTutorialRequestById(requestId);
        // Update tutorial request status based on response
        tutorialRequest.setStatus(response);
        tutorialRequestRepository.save(tutorialRequest);
    }

    // Get all tutorial requests
    public List<TutorialRequest> getAllTutorialRequests() {
        return tutorialRequestRepository.findAll();
    }

    // Get tutorial request by ID
    public TutorialRequest getTutorialRequestById(Long id) {
        return tutorialRequestRepository.getTutorialRequestById(id);
    }

    // Delete tutorial request by ID
    public void deleteTutorialRequest(Long id) {
        tutorialRequestRepository.deleteById(id);
    }

    // Get tutorial requests by student ID
    public List<TutorialRequest> getTutorialRequestsByStudent(Long id){
        return tutorialRequestRepository.findByStudentId(id);
    }

    // Get tutorial requests by tutor ID
    public List<TutorialRequest> getTutorialRequestsByTutor(Long id){
        return tutorialRequestRepository.findByTutorId(id);
    }

    // Get tutorial requests by status
    public List<TutorialRequest> getTutorialRequestsByStatus(String status){
        return tutorialRequestRepository.findByStatus(status);
    }

    // Create a new tutorial request
    public TutorialRequest createTutorialRequest(TutorialRequestRequest request) {

        TutorialRequest newTutorialRequest = new TutorialRequest();
        newTutorialRequest.setDayOfWeek(request.getDayOfWeek());
        newTutorialRequest.setStartTime(request.getStartTime());
        newTutorialRequest.setEndTime(request.getEndTime());
        newTutorialRequest.setSubject(request.getSubject());
        newTutorialRequest.setStudent(userRepository.getUserById(request.getStudentId()));
        newTutorialRequest.setTutor(userRepository.getUserById(request.getTutorId()));

        tutorialRequestRepository.save(newTutorialRequest);

        return newTutorialRequest;
    }


}
