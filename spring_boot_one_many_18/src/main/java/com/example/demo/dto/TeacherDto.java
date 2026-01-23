package com.example.demo.dto;

import java.util.Set;

import com.example.demo.entity.Student;


public record TeacherDto(Integer teacherId,String teacherName,String department,Set<Student> students) {

}

