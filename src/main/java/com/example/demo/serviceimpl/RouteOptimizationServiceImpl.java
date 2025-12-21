package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final RouteOptimizationResultRepository repository;

    public RouteOptimizationServiceImpl(RouteOptimizationResultRepository repository) {
        this.repository = repository;
    }

    @Override
    public RouteOptimizationResult save(RouteOptimizationResult result) {
        return repository.save(result);
    }

    @Override
    public List<RouteOptimizationResult> findAll() {
        return repository.findAll();
    }

    @Override
    public RouteOptimizationResult findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Route Optimization Result not found"));
    }

    @Override
    public RouteOptimizationResult update(Long id, RouteOptimizationResult result) {
        RouteOptimizationResult existing = findById(id);
        existing.setOptimizedDistanceKm(result.getOptimizedDistanceKm());
        existing.setEstimatedFuelUsageL(result.getEstimatedFuelUsageL());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
