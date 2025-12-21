package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService service;

    public RouteOptimizationController(RouteOptimizationService service) {
        this.service = service;
    }

    @PostMapping("/{shipmentId}")
    public RouteOptimizationResult optimize(@PathVariable Long shipmentId) {
        return service.optimizeRoute(shipmentId);
    }

    @GetMapping("/result/{id}")
    public RouteOptimizationResult getResult(@PathVariable Long id) {
        return service.getResult(id);
    }
}
