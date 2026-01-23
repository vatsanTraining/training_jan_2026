package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.jwt.JwtAuthenticationFilter;
import com.example.demo.services.UserServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserServiceImpl userDetailsService; 
    
    @Autowired
    BCryptPasswordEncoder encoder;
    
    @Autowired
    private  JwtAuthenticationFilter jwtAuthFilter;
    
//    @Bean
//     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//        .csrf(csrf -> csrf.disable()) 
//        .authorizeHttpRequests(auth -> auth
//            .requestMatchers(PathRequest.toH2Console()).permitAll() 
//            .requestMatchers("/api/v1/auth/**").permitAll()
//            .anyRequest().authenticated()
//        )
//        .headers(headers -> headers
//            .frameOptions(frame -> frame.sameOrigin()) 
//        )
//        .httpBasic(Customizer.withDefaults());
//  
//        return http.build();
//    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
       .csrf(csrf -> csrf.disable()) 
       .authorizeHttpRequests(auth -> auth
           .requestMatchers(PathRequest.toH2Console()).permitAll() 
           .requestMatchers("/api/v1/auth/**").permitAll()
           .anyRequest().authenticated()
       )
       .headers(headers -> headers
           .frameOptions(frame -> frame.sameOrigin()) 
       )
       .httpBasic(Customizer.withDefaults());
 
       return http.build();
   }

}

