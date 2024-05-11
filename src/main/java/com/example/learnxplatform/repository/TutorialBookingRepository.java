package com.example.learnxplatform.repository;

import com.example.learnxplatform.entity.TutorialBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialBookingRepository extends JpaRepository<TutorialBooking, Long> {

    // Find tutorial bookings by student ID
    List<TutorialBooking> findByStudentId(Long id);

    // Find tutorial bookings by tutor ID
    List<TutorialBooking> findByTutorId(Long id);

    // Get tutorial booking by ID
    TutorialBooking getTutorialBookingById(Long id);
}
