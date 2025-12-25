package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String secret;
    private final long expirationMs;

    // Used by tests
    public JwtUtil(String secret, long expirationMs) {
        this.secret = secret;
        this.expirationMs = expirationMs;
    }

    // Used by Spring
    public JwtUtil() {
        this.secret = "default-test-secret-key-which-is-long";
        this.expirationMs = 3600000;
    }

    public String generateToken(Long userId, String email, String role) {
        long expiry = System.currentTimeMillis() + expirationMs;
        String payload = userId + "|" + email + "|" + role + "|" + expiry;
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    public Jws<Claims> validateToken(String token) {
        try {
            String decoded = new String(Base64.getDecoder().decode(token));
            String[] parts = decoded.split("\\|");

            long expiry = Long.parseLong(parts[3]);
            if (System.currentTimeMillis() > expiry) {
                throw new ExpiredJwtException("Token expired");
            }

            Map<String, Object> map = new HashMap<>();
            map.put("userId", Long.parseLong(parts[0]));
            map.put("email", parts[1]);
            map.put("role", parts[2]);

            return new Jws<>(new Claims(map));

        } catch (ExpiredJwtException e) {
            throw e;
        } catch (Exception e) {
            throw new JwtException("Invalid token");
        }
    }
}
