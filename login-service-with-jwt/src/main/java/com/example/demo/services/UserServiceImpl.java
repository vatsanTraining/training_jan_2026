package com.example.demo.services;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.WebUser;
import com.example.demo.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService{

	
	   private final UserRepository userRepository;
	    private final PasswordEncoder passwordEncoder;

	 
	
	
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

public WebUser saveUser(RegistrationRequest user) {
	
    WebUser entity = new WebUser();
    entity.setUsername(user.username());
    entity.setEmail(user.email());
    entity.setPassword(passwordEncoder.encode(user.password()));
    entity.setRole(user.role());

		return userRepository.save(entity);
		
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
