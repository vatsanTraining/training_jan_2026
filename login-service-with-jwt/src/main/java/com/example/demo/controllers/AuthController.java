package com.example.demo.controllers;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.WebUser;
import com.example.demo.services.AuthService;
import com.example.demo.services.UserServiceImpl;

import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserServiceImpl userService;
 
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        if (userService.existsByUsername(registrationRequest.username())) {
            return new ResponseEntity<>("Error: Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(registrationRequest.email())) {
            return new ResponseEntity<>("Error: Email is already in use!", HttpStatus.BAD_REQUEST);
        }

        userService.saveUser(registrationRequest);
        
        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
    

    @PostMapping(path =  "/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {

        String token = authService.authenticate(
                request.username(),
                request.password()
        );

        return ResponseEntity.ok(token);
    }



}