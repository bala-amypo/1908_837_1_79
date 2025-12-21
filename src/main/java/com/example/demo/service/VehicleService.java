package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Vehicle;

public interface VehicleService {
    Vehicle addVehicle(Long userId, Vehicle vehicle);
    List<Vehicle> getVehiclesByUser(Long userId);
    Vehicle findById(Long id);
}
