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

//Global AuthenticationManager configured with an AuthenticationProvider bean.
//UserDetailsService beans will not be used by Spring Security for automatically 
//configuring username/password login. Consider removing the AuthenticationProvider bean.
//Alternatively, consider using the UserDetailsService in a manually instantiated DaoAuthenticationProvider. If the current configuration is intentional, to turn off this warning, increase the logging level of 'org.springframework.security.config.annotation.authentication.configuration.InitializeUserDetailsBeanManagerConfigurer' to ERROR
