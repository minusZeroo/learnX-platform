package com.example.learnxplatform.repository;

import com.example.learnxplatform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username
    User findByUsername(String studentNumber);

    // Get user by ID
    User getUserById(Long id);
}