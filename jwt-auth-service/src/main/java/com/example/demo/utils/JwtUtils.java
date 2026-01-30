package com.example.demo.utils;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtils {

	@Value("${jwt.secret}")
	 private String secret;

	 @Value("${jwt.expiration}")
	 private long jwtExpirationInMs; 
	 
	 private Key key;

	 @PostConstruct
	 public void init(){
	     this.key = Keys.hmacShaKeyFor(secret.getBytes());
	 }

	 public String generateToken(String username) {
	     return Jwts.builder()
	             .setSubject(username)
	             .setIssuedAt(new Date(System.currentTimeMillis()))
	             .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
	             .signWith(key, SignatureAlgorithm.HS256)
	             .compact();
	 }

}
