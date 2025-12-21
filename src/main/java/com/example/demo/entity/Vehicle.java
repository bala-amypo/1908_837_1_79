package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;

    @ManyToOne
    private User user;

    public Vehicle() {}

    public Long getId() { 
        return id; 
    }
    public String getVehicleNumber() { 
        return vehicleNumber; 
    }
    public Double getCapacityKg() { 
        return capacityKg; 
    }
    public Double getFuelEfficiency() { 
        return fuelEfficiency; 
    }
    public User getUser() { 
        return user; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }
    public void setVehicleNumber(String vehicleNumber) { 
        this.vehicleNumber = vehicleNumber; 
    }
    public void setCapacityKg(Double capacityKg) { 
        this.capacityKg = capacityKg; 
    }
    public void setFuelEfficiency(Double fuelEfficiency) { 
        this.fuelEfficiency = fuelEfficiency; 
    }
    public void setUser(User user) { 
        this.user = user; 
    }
}
