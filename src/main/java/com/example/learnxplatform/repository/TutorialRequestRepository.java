package com.example.learnxplatform.repository;

import com.example.learnxplatform.entity.TutorialRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRequestRepository extends JpaRepository<TutorialRequest, Long> {

    // Find tutorial requests by tutor ID
    List<TutorialRequest> findByTutorId(Long tutorId);

    // Find tutorial requests by student ID
    List<TutorialRequest> findByStudentId(Long studentId);

    // Find tutorial requests by status
    List<TutorialRequest> findByStatus(String status);

    // Get tutorial request by ID
    TutorialRequest getTutorialRequestById(Long requestId);

    // Get all tutorial requests
    List<TutorialRequest> findAll();

    // Delete tutorial request by ID
    void deleteById(Long id);
}
