package com.example.demo.service;

import com.example.demo.entity.Location;
import java.util.List;

public interface LocationService {
    Location save(Location location);
    List<Location> findAll();
    Location findById(Long id);
    Location update(Long id, Location location);
    void delete(Long id);
}
