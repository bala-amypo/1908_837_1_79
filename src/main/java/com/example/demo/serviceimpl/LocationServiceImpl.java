package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location save(Location location) {
        return repository.save(location);
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }

    @Override
    public Location findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
    }

    @Override
    public Location update(Long id, Location location) {
        Location existing = findById(id);
        existing.setName(location.getName());
        existing.setLatitude(location.getLatitude());
        existing.setLongitude(location.getLongitude());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
