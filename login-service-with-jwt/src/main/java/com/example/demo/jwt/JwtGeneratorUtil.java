package com.example.demo.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtGeneratorUtil {

 @Value("${jwt.secret}")
 private String secret;

 @Value("${jwt.expiration.ms}")
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

 public boolean isTokenValid(String jwt, UserDetails userDetails) {
	    final String username = extractUsername(jwt);
	    return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
	}

	 private boolean isTokenExpired(String token) {
		 	    final Date expiration = Jwts.parserBuilder()
	            .setSigningKey(key)
	            .build()
	            .parseClaimsJws(token)
	            .getBody()
	            .getExpiration();
	    return expiration.before(new Date());
	 }
	 public String extractUsername(String token) {
	 return Jwts.parserBuilder()
			 .setSigningKey(key)
			 .build()
			 .parseClaimsJws(token)
			 .getBody()
			 .getSubject();
 }
}
