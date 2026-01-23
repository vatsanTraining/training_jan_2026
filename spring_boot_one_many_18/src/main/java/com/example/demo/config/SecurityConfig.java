package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

	
	@Bean
	BCryptPasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	@Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable()) // Or Customizer.withDefaults() if required
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/api/admin/**").hasRole("ADMIN")
	            .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
	            .anyRequest().authenticated()
	        )
	        .httpBasic(Customizer.withDefaults()); // Lambda style for Basic Auth

	    return http.build();
	}

	@Bean
	 UserDetailsManager userDetailsService() {
		
	
	    UserDetails user = User.builder().username("india").password(encoder().encode("india")).roles("USER").build();
	    
	return new InMemoryUserDetailsManager(user);
}
	
}
