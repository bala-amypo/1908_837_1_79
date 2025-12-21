package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repository;

    public ShipmentServiceImpl(ShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Shipment save(Shipment shipment) {
        return repository.save(shipment);
    }

    @Override
    public List<Shipment> findAll() {
        return repository.findAll();
    }

    @Override
    public Shipment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }

    @Override
    public Shipment update(Long id, Shipment shipment) {
        Shipment existing = findById(id);
        existing.setWeightKg(shipment.getWeightKg());
        existing.setScheduledDate(shipment.getScheduledDate());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
