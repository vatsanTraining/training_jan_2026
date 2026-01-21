package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	
	@Bean
	PasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityConfi(HttpSecurity http) throws Exception{
		
		http.csrf(AbstractHttpConfigurer::disable)
		     .authorizeHttpRequests( req -> req.requestMatchers("/first").permitAll())
		     .authorizeHttpRequests( req -> req.requestMatchers("/second").authenticated())
		     
		   .httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	UserDetailsManager   userConfig(BCryptPasswordEncoder encoder) {
		
		UserDetails indiaUser = User.withUsername("india")
			       .password(encoder.encode("india")).authorities("ADMIN").build();

			UserDetails nepalUser = User.withUsername("nepal")
			       .password(encoder.encode("nepal")).authorities("USER").build();
			    return new InMemoryUserDetailsManager(indiaUser,nepalUser);

	}
}
