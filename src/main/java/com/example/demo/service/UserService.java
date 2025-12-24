package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    // This method was missing or named differently
    User register(User user);
    
    User findByEmail(String email);
    User findById(Long id);
}