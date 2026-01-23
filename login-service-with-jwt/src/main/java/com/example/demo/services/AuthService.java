package com.example.demo.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.demo.jwt.JwtGeneratorUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	
    private final AuthenticationManager authenticationManager;
    private final JwtGeneratorUtil jwtGeneratorUtil;

    public String authenticate(String username, String password) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username, password)
                );

        return jwtGeneratorUtil.generateToken(authentication.getName());
    }


}
