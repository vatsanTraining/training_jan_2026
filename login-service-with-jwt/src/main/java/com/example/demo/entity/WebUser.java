package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "portal_users")
@Data 
@NoArgsConstructor
@AllArgsConstructor

public class WebUser {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(unique = true, nullable = false,name="username")
	    private String username;
	    private String email;
	    private String password;
	    @Column(nullable = false)
	    private String role;
	   
}
