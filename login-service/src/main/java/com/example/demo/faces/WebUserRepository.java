package com.example.demo.faces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.WebUser;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {

	UserDetails findByUserName(String username);

}
