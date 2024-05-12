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

    @Override
    public UserDetails loadUserByUsername(String studentNumber) throws UsernameNotFoundException {
        User user = userRepository.findByStudentNumber(studentNumber);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with student number: " + studentNumber);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getStudentNumber(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().name()));
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User findByStudentNumber(String studentNumber) {
        return userRepository.findByStudentNumber(studentNumber);
    }

    public User findById(Long id) {
        return userRepository.getUserById(id);
    }


}
