package com.example.demo.service;

import com.example.demo.entity.Shipment;
import java.util.List;

public interface ShipmentService {
    Shipment save(Shipment shipment);
    List<Shipment> findAll();
    Shipment findById(Long id);
    Shipment update(Long id, Shipment shipment);
    void delete(Long id);
}
