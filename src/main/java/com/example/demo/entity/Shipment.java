package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    private Double weightKg;
    private LocalDate scheduledDate;

    public Shipment() {}

    public Long getId() { 
        return id; 
    }
    public Vehicle getVehicle() { 
        return vehicle; 
    }
    public Location getPickupLocation() { 
        return pickupLocation; 
    }
    public Location getDropLocation() { 
        return dropLocation; 
    }
    public Double getWeightKg() { 
        return weightKg; 
    }
    public LocalDate getScheduledDate() { 
        return scheduledDate;
    }

    public void setId(Long id) { 
        this.id = id; 
    }
    public void setVehicle(Vehicle vehicle) { 
        this.vehicle = vehicle; 
    }
    public void setPickupLocation(Location pickupLocation) { 
        this.pickupLocation = pickupLocation; 
    }
    public void setDropLocation(Location dropLocation) { 
        this.dropLocation = dropLocation; 
    }
    public void setWeightKg(Double weightKg) { 
        this.weightKg = weightKg; 
    }
    public void setScheduledDate(LocalDate scheduledDate) { 
        this.scheduledDate = scheduledDate; 
    }
}
