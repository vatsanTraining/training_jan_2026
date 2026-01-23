package com.example.demo.controllers;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.WebUser;
import com.example.demo.services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserServiceImpl userService; 
    
    
    
    @Autowired
    private PasswordEncoder passwordEncoder; 
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        if (userService.existsByUsername(registrationRequest.username())) {
            return new ResponseEntity<>("Error: Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(registrationRequest.email())) {
            return new ResponseEntity<>("Error: Email is already in use!", HttpStatus.BAD_REQUEST);
        }

        WebUser user = new WebUser();
        user.setUsername(registrationRequest.username());
        user.setEmail(registrationRequest.email());
        user.setPassword(passwordEncoder.encode(registrationRequest.password())); 
        user.setRole(registrationRequest.role());
        
        userService.saveUser(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
    



}