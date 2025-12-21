package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;

    public Location() {}

    public Long getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public Double getLatitude() { 
        return latitude; 
    }
    public Double getLongitude() { 
        return longitude; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public void setLatitude(Double latitude) { 
        this.latitude = latitude; 
    }
    public void setLongitude(Double longitude) { 
        this.longitude = longitude; 
    }
}
