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

    public TutorAvailability createTutorAvailability(TutorAvailabilityRequest request) {
        TutorAvailability tutorAvailability = new TutorAvailability();
        tutorAvailability.setTutor(userRepository.getUserById(request.getTutorId()));
        tutorAvailability.setDayOfWeek(request.getDayOfWeek());
        tutorAvailability.setStartTime(request.getStartTime());
        tutorAvailability.setEndTime(request.getEndTime());
        tutorAvailability.setSubject(request.getSubject());

        return tutorAvailabilityRepository.save(tutorAvailability);
    }

    public List<TutorAvailability> getAllTutorAvailabilities() { return tutorAvailabilityRepository.findAll(); }

    public TutorAvailability getTutorAvailability(Long id) {
        return  tutorAvailabilityRepository.getTutorAvailabilityById(id);
    }

    public void deleteTutorAvailability(Long id) {
        tutorAvailabilityRepository.deleteById(id);
    }

    public List<TutorAvailability> getTutorAvailabilityByDayOfWeek(Integer index) {
        return tutorAvailabilityRepository.getTutorAvailabilityByDayOfWeek(index);
    }

    public List<TutorAvailability> getTutorAvailabilityByTutor(Long id) {
        return tutorAvailabilityRepository.findByTutorId(id);
    }
}
