package com.example.demo.utils;

import com.example.demo.dto.TeacherDto;
import com.example.demo.entity.Teacher;

public class CustomMapper {

    public static TeacherDto toDto(Teacher teacher) {
        return new TeacherDto(
            teacher.getTeacherId(),
        		teacher.getTeacherName(),
            teacher.getDepartment(),
            teacher.getStudents() 
            
        );
    }

    public static Teacher toEntity(TeacherDto dto) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(dto.teacherId());
        teacher.setTeacherName(dto.teacherName());
        teacher.setDepartment(dto.department());
        teacher.setStudents(dto.students());
        return teacher;
    }

}
