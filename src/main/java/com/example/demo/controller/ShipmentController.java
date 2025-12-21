package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @PostMapping
    public Shipment create(@RequestBody Shipment shipment) {
        return service.save(shipment);
    }

    @GetMapping
    public List<Shipment> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Shipment get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Shipment update(@PathVariable Long id, @RequestBody Shipment shipment) {
        return service.update(id, shipment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
