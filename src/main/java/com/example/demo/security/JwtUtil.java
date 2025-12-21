package com.example.demo.security;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

    private final String secretKey;
    private final long expirationMillis;

    public JwtUtil(String secretKey, long expirationMillis) {
        this.secretKey = secretKey;
        this.expirationMillis = expirationMillis;
    }

    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + expirationMillis)
                )
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
}
