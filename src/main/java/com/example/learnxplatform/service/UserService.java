package com.example.learnxplatform.service;

import com.example.learnxplatform.entity.User;
import com.example.learnxplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Load user by username for authentication
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // Create UserDetails object with username, password, and role
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().name()));
    }

    // Register a new user
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Find user by username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Find user by ID
    public User findById(Long id) {
        return userRepository.getUserById(id);
    }

}
