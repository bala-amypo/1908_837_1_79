package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import java.util.List;

public interface VehicleService {
    Vehicle save(Vehicle vehicle);
    List<Vehicle> findAll();
    Vehicle findById(Long id);
    Vehicle update(Long id, Vehicle vehicle);
    void delete(Long id);
}
