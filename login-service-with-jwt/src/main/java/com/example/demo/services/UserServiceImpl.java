package com.example.demo.services;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.WebUser;
import com.example.demo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{

	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

public WebUser saveUser(WebUser user) {
		
		return userRepository.save(user);
		
	}


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    WebUser portalUser = userRepository.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

	    return User.builder()
	            .username(portalUser.getUsername())
	            .password(portalUser.getPassword())
	            .roles(portalUser.getRole()) 
	            .build();
	}

	

}