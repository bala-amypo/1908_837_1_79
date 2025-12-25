package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.RouteOptimizationService;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final RouteOptimizationService routeService;

    public ShipmentController(ShipmentService shipmentService,
                              RouteOptimizationService routeService) {
        this.shipmentService = shipmentService;
        this.routeService = routeService;
    }

    @PostMapping("/{vehicleId}")
    public Shipment create(@PathVariable Long vehicleId,
                           @RequestBody Shipment shipment) {
        return shipmentService.createShipment(vehicleId, shipment);
    }

    @PostMapping("/{shipmentId}/optimize")
    public Object optimize(@PathVariable Long shipmentId) {
        return routeService.optimizeRoute(shipmentId);
    }
}
