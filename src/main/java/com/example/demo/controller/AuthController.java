package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth") // Common practice to use /api/auth
public class AuthController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        // Use a secret at least 32 chars long
        this.jwtUtil = new JwtUtil("secure-logistics-secret-key-32-characters!!", 86400000);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest reg) {
        User user = User.builder()
                .name(reg.getName())
                .email(reg.getEmail())
                .password(reg.getPassword()) // Service will encode this
                .role(reg.getRole())
                .build();
        
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest login) {
        User user = userService.findByEmail(login.getEmail());

        if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
            return ResponseEntity.ok(Map.of(
                "token", token,
                "type", "Bearer"
            ));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}