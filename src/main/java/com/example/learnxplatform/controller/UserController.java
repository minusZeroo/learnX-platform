package com.example.learnxplatform.controller;

import com.example.learnxplatform.dto.LoginRequest;
import com.example.learnxplatform.entity.User;
import com.example.learnxplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;



import java.util.HashMap;

@RestController
@RequestMapping("/api/users") // Base URL for this controller
@CrossOrigin(origins = "http://localhost:3000") // Allowing cross-origin requests from localhost:3000
public class UserController {

    @Autowired
    private UserService userService; // Autowiring the service class

    @Autowired
    private PasswordEncoder passwordEncoder; // Autowiring the password encoder

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User registeredUser = userService.registerUser(user);

        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    // Endpoint to log in a user
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userService.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        // User is authenticated, create response
        Map<String, Object> response = new HashMap<>();
        response.put("username", user.getUsername());
        response.put("role", user.getRole().name());
        response.put("userId", user.getId());

        return ResponseEntity.ok(response);
    }

    // Endpoint to get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
