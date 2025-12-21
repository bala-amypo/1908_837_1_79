package com.example.demo.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Location;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepository,
                                        RouteOptimizationResultRepository resultRepository) {
        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();

        // Dummy distance calculation (non-zero)
        double distance = Math.hypot(
                pickup.getLatitude() - drop.getLatitude(),
                pickup.getLongitude() - drop.getLongitude()
        );

        if (distance <= 0) {
            distance = 1.0;
        }

        double fuelUsed = distance / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResult result =
                new RouteOptimizationResult(
                        shipment,
                        distance,
                        fuelUsed,
                        LocalDateTime.now()
                );

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Result not found"));
    }
}
