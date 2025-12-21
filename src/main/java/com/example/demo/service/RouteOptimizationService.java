package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;

import java.util.List;

public interface RouteOptimizationService {

    RouteOptimizationResult save(RouteOptimizationResult result);

    List<RouteOptimizationResult> findAll();

    RouteOptimizationResult findById(Long id);

    RouteOptimizationResult update(Long id, RouteOptimizationResult result);

    void delete(Long id);
}
