package com.example.learnxplatform.service;

import com.example.learnxplatform.dto.TutorialBookingRequest;
import com.example.learnxplatform.entity.TutorialBooking;
import com.example.learnxplatform.repository.TutorialBookingRepository;
import com.example.learnxplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialBookingService {

    @Autowired
    private TutorialBookingRepository tutorialBookingRepository;

    @Autowired
    private UserRepository userRepository;

    // Book a tutorial
    public TutorialBooking bookTutorial(TutorialBookingRequest request) {
        // Validate request and handle booking
        TutorialBooking tutorialBooking = new TutorialBooking();
        tutorialBooking.setStudent(userRepository.getUserById(request.getStudentId()));
        tutorialBooking.setTutor(userRepository.getUserById(request.getTutorId()));
        tutorialBooking.setSubject(request.getSubject());
        tutorialBooking.setDayOfWeek(request.getDayOfWeek());
        tutorialBooking.setStartTime(request.getStartTime());
        tutorialBooking.setEndTime(request.getEndTime());
        return tutorialBookingRepository.save(tutorialBooking);
    }

    // Get all tutorial bookings
    public List<TutorialBooking> getAllTutorialBookings() {
        return tutorialBookingRepository.findAll();
    }

    // Get tutorial bookings by student ID
    public List<TutorialBooking> getTutorialBookingByStudent(Long id) {
        return tutorialBookingRepository.findByStudentId(id);
    }

    // Get tutorial bookings by tutor ID
    public List<TutorialBooking> getTutorialBookingByTutor(Long id) {
        return tutorialBookingRepository.findByTutorId(id);
    }

    // Get tutorial booking by ID
    public TutorialBooking getTutorialBookingById(Long id) {
        return tutorialBookingRepository.getTutorialBookingById(id);
    }

    // Delete tutorial booking by ID
    public void deleteTutorialBooking(Long id) {
        tutorialBookingRepository.deleteById(id);
    }

    // Implement other CRUD operations if needed
}
