package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route-optimizations")
public class RouteOptimizationController {

    private final RouteOptimizationService service;

    public RouteOptimizationController(RouteOptimizationService service) {
        this.service = service;
    }

    @PostMapping
    public RouteOptimizationResult create(@RequestBody RouteOptimizationResult result) {
        return service.save(result);
    }

    @GetMapping
    public List<RouteOptimizationResult> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RouteOptimizationResult get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public RouteOptimizationResult update(@PathVariable Long id,
                                          @RequestBody RouteOptimizationResult result) {
        return service.update(id, result);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
