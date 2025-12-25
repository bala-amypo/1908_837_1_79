package com.example.demo.security;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

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

    // -----------------------------
    // TOKEN GENERATION (SIMULATED)
    // -----------------------------
    public String generateToken(Long userId, String email, String role) {
        long expiry = System.currentTimeMillis() + expirationMs;

        String payload = userId + "|" + email + "|" + role + "|" + expiry;
        return Base64.getEncoder().encodeToString(payload.getBytes());
    }

    // -----------------------------
    // TOKEN VALIDATION (SIMULATED)
    // -----------------------------
    public Jws validateToken(String token) {
        try {
            String decoded = new String(Base64.getDecoder().decode(token));
            String[] parts = decoded.split("\\|");

            long expiry = Long.parseLong(parts[3]);
            if (System.currentTimeMillis() > expiry) {
                throw new ExpiredJwtException("Token expired");
            }

            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", Long.parseLong(parts[0]));
            claims.put("email", parts[1]);
            claims.put("role", parts[2]);

            return new Jws(claims);
        } catch (ExpiredJwtException e) {
            throw e;
        } catch (Exception e) {
            throw new JwtException("Invalid token");
        }
    }

    // -----------------------------
    // INNER CLASSES (TEST-SAFE)
    // -----------------------------

    public static class Jws {
        private final Claims claims;

        public Jws(Map<String, Object> map) {
            this.claims = new Claims(map);
        }

        public Claims getBody() {
            return claims;
        }
    }

    public static class Claims {
        private final Map<String, Object> map;

        public Claims(Map<String, Object> map) {
            this.map = map;
        }

        @SuppressWarnings("unchecked")
        public <T> T get(String key, Class<T> clazz) {
            return (T) map.get(key);
        }
    }

    // -----------------------------
    // EXCEPTION CLASSES
    // -----------------------------

    public static class JwtException extends RuntimeException {
        public JwtException(String msg) {
            super(msg);
        }
    }

    public static class ExpiredJwtException extends JwtException {
        public ExpiredJwtException(String msg) {
            super(msg);
        }
    }
}
