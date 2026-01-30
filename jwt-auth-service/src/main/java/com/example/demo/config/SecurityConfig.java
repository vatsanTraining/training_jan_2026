package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	
	@Bean
	BCryptPasswordEncoder encoder() {
	
		return new BCryptPasswordEncoder();
	}
	
	
	  @Bean
	  AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		     return config.getAuthenticationManager();
		 }
		
		 @Bean
		  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		     http
		         .csrf(csrf -> csrf.disable())
		         .httpBasic(basic -> basic.disable())
		         .formLogin(form -> form.disable())
		         .authorizeHttpRequests(auth -> auth
		             .requestMatchers("/api/v1/auth/**","/error").permitAll() 
		                          .anyRequest().authenticated()
		         )
		         .sessionManagement(sess -> 
		             sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); 
		     
		     return http.build();
		 }
		 
		 
		 
		 @Bean
		  UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {

		     UserDetails user = User.builder()
		             .username("india")
		             .password(encoder.encode("india")) 
		             .roles("USER")
		             .build();

		     UserDetails admin = User.builder()
		             .username("lanka")
		             .password(encoder.encode("lanka"))
		             .roles("ADMIN", "USER")
		             .build();

		     return new InMemoryUserDetailsManager(user, admin);
		 }
}
