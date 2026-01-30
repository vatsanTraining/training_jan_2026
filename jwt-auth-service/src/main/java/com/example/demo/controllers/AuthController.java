package com.example.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthRequest;
import com.example.demo.utils.JwtUtils;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {

	
	private final AuthenticationManager authenticationManager;
	 private final JwtUtils util;
	 
	 public AuthController(AuthenticationManager authenticationManager, 
	                       JwtUtils util) {
	     this.authenticationManager = authenticationManager;
	     this.util = util;
	 }

	 @PostMapping("/login")
	 public ResponseEntity<String> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {

	     try {
	         authenticationManager.authenticate(
	                 new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password())
	         );
	     } catch (BadCredentialsException e) {
	         throw new Exception("Incorrect username or password", e); 
	     }

	      String jwt = util.generateToken(authRequest.username());

	     return ResponseEntity.ok(jwt);
	 }
}
