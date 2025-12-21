package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = new JwtUtil("mysecretkey", 86400000);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
