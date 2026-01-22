package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Teacher;
import com.example.demo.repos.TeacherRepository;
import com.example.demo.services.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/teachers")
@AllArgsConstructor
public class TeacherController {

	
	
	
	private TeacherRepository repo;
	
	@GetMapping
	ResponseEntity<List<Teacher>> findAll(){
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.repo.findAll());
		
	}
	

	@PostMapping
	ResponseEntity<Teacher> save(@Valid @RequestBody Teacher teacher){
		
		Teacher saved=this.repo.save(teacher);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
		
	}
}
