package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	
	@Query("SELECT s FROM Teacher t JOIN t.students s WHERE t.department = :dept")
	List<Student> findStudentsByDept(@Param("dept") String department);

	   @Query("SELECT AVG(s.mark) FROM Teacher t JOIN t.students s WHERE t.department = :dept")
	    Double findAverageMarkByDepartment(@Param("dept") String department);

}
