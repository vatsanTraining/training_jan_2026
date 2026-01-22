package com.example.demo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tsc_teacher")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="teacher_id")
	int teacherId;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	@Column(name="department")
	private String department;
	
	@OneToMany(targetEntity = Student.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_ref", referencedColumnName = "teacher_id")
	Set<Student> students;
	
	
}