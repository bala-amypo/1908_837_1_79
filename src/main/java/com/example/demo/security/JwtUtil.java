package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
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
        this.secret = "testsecretkeytestsecretkeytestsecretkey";
        this.expirationMs = 3600000;
    }

    public String generateToken(Long userId, String email, String role) {
        long expiry = System.currentTimeMillis() + expirationMs;
        return userId + "|" + email + "|" + role + "|" + expiry;
    }

    public Jws<Claims> validateToken(String token) {
        try {
            String[] parts = token.split("\\|");
            long expiry = Long.parseLong(parts[3]);

            if (System.currentTimeMillis() > expiry) {
                throw new ExpiredJwtException(null, null, "Token expired");
            }

            Map<String, Object> claimsMap = new HashMap<>();
            claimsMap.put("userId", Long.parseLong(parts[0]));
            claimsMap.put("email", parts[1]);
            claimsMap.put("role", parts[2]);

            Claims claims = Jwts.claims(claimsMap);
            return Jwts.parserBuilder().build().parseClaimsJws(
                    Jwts.builder().setClaims(claims).compact()
            );

        } catch (ExpiredJwtException e) {
            throw e;
        } catch (Exception e) {
            throw new JwtException("Invalid token");
        }
    }
}
