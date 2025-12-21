package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Location;

public interface LocationService {

    Location createLocation(Location location);

    List<Location> getAllLocations();
}
