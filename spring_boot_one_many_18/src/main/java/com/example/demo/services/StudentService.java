package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;

@Service
public class StudentService {

	public StudentDto save(StudentDto dto) {
		return dto;
	}

}
