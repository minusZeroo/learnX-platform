package com.example.learnxplatform.repository;

import com.example.learnxplatform.entity.TutorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorAvailabilityRepository extends JpaRepository<TutorAvailability, Long> {

    // Find tutor availabilities by tutor ID
    List<TutorAvailability> findByTutorId(Long id);

    // Get tutor availability by ID
    TutorAvailability getTutorAvailabilityById(Long id);

    // Get tutor availabilities by day of week
    List<TutorAvailability> getTutorAvailabilityByDayOfWeek(Integer index);

}
