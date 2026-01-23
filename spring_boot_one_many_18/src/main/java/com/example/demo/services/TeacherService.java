package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDto;
import com.example.demo.dto.TeacherDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.repos.TeacherRepository;
import com.example.demo.utils.CustomMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor
@Data
public class TeacherService {

	private TeacherRepository repo;

	public Teacher save(TeacherDto dto) {
		return this.repo.save(CustomMapper.toEntity(dto));
	}

	public List<Teacher> findAll() {
		return this.repo.findAll();
	}

	public Double getAverageMark(String dept) {
	    List<Student> students = repo.findStudentsByDept(dept);
	    return students.stream()
	                   .mapToDouble(s -> s.getMark().doubleValue())
	                   .average()
	                   .orElse(0.0);
	}

}
