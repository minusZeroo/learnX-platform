package com.example.learnxplatform.service;


import com.example.learnxplatform.dto.TutorAvailabilityRequest;
import com.example.learnxplatform.entity.TutorAvailability;
import com.example.learnxplatform.repository.TutorAvailabilityRepository;
import com.example.learnxplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorAvailabilityService {

    @Autowired
    private TutorAvailabilityRepository tutorAvailabilityRepository;

    @Autowired
    private UserRepository userRepository;

    // Create a new tutor availability
    public TutorAvailability createTutorAvailability(TutorAvailabilityRequest request) {
        // Validate request and handle creation
        TutorAvailability tutorAvailability = new TutorAvailability();
        tutorAvailability.setTutor(userRepository.getUserById(request.getTutorId()));
        tutorAvailability.setDayOfWeek(request.getDayOfWeek());
        tutorAvailability.setStartTime(request.getStartTime());
        tutorAvailability.setEndTime(request.getEndTime());
        tutorAvailability.setSubject(request.getSubject());
        return tutorAvailabilityRepository.save(tutorAvailability);
    }

    // Get all tutor availabilities
    public List<TutorAvailability> getAllTutorAvailabilities() {
        return tutorAvailabilityRepository.findAll();
    }

    // Get tutor availability by ID
    public TutorAvailability getTutorAvailabilityById(Long id) {
        return tutorAvailabilityRepository.getTutorAvailabilityById(id);
    }

    // Delete tutor availability by ID
    public void deleteTutorAvailability(Long id) {
        tutorAvailabilityRepository.deleteById(id);
    }

    // Get tutor availabilities by day of week
    public List<TutorAvailability> getTutorAvailabilityByDayOfWeek(Integer index) {
        return tutorAvailabilityRepository.getTutorAvailabilityByDayOfWeek(index);
    }

    // Get tutor availabilities by tutor ID
    public List<TutorAvailability> getTutorAvailabilityByTutor(Long id) {
        return tutorAvailabilityRepository.findByTutorId(id);
    }

    // Implement other CRUD operations if needed
}
