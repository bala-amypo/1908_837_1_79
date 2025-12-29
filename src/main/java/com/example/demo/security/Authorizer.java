package com.example.demo.security;

import io.jsonwebtoken.Claims;

/**
 * Lightweight authorization utility.
 * Does NOT depend on Spring Security.
 * Uses role information from JWT claims.
 */
public final class Authorizer {

    private Authorizer() {
        // prevent object creation
    }

    /**
     * Allows access for USER or ADMIN roles
     */
    public static void authorizeUser(Claims claims) {
        if (claims == null) {
            throw new RuntimeException("Access denied");
        }

        String role = claims.get("role", String.class);

        if (role == null ||
           (!role.equalsIgnoreCase("USER") &&
            !role.equalsIgnoreCase("ADMIN"))) {
            throw new RuntimeException("Access denied");
        }
    }

    /**
     * Allows access ONLY for ADMIN role
     */
    public static void authorizeAdmin(Claims claims) {
        if (claims == null) {
            throw new RuntimeException("Access denied");
        }

        String role = claims.get("role", String.class);

        if (role == null || !role.equalsIgnoreCase("ADMIN")) {
            throw new RuntimeException("Access denied");
        }
    }
}
