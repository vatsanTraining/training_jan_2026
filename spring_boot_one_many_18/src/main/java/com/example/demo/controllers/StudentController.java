package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.services.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/students")
@AllArgsConstructor
public class StudentController {

	
	
	
	private StudentService service;
	

	@PostMapping
	ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto dto){
		
		StudentDto saved = this.service.save(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
		
	}
}
