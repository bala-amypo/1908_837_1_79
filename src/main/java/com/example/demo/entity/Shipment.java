package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double weightKg;

    private LocalDate scheduledDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id")
    private Location pickupLocation;

    @ManyToOne
    @JoinColumn(name = "drop_location_id")
    private Location dropLocation;

    // -------- Constructors --------

    public Shipment() {
    }

    public Shipment(Long id, Double weightKg, LocalDate scheduledDate,
                    Vehicle vehicle, Location pickupLocation, Location dropLocation) {
        this.id = id;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
    }

    // -------- Getters & Setters --------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }

    public LocalDate getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Location getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(Location pickupLocation) { this.pickupLocation = pickupLocation; }

    public Location getDropLocation() { return dropLocation; }
    public void setDropLocation(Location dropLocation) { this.dropLocation = dropLocation; }

    // -------- Manual Builder (REQUIRED BY TESTS) --------

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private Double weightKg;
        private LocalDate scheduledDate;
        private Vehicle vehicle;
        private Location pickupLocation;
        private Location dropLocation;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder weightKg(Double weightKg) {
            this.weightKg = weightKg;
            return this;
        }

        public Builder scheduledDate(LocalDate scheduledDate) {
            this.scheduledDate = scheduledDate;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder pickupLocation(Location pickupLocation) {
            this.pickupLocation = pickupLocation;
            return this;
        }

        public Builder dropLocation(Location dropLocation) {
            this.dropLocation = dropLocation;
            return this;
        }

        public Shipment build() {
            return new Shipment(id, weightKg, scheduledDate,
                    vehicle, pickupLocation, dropLocation);
        }
    }
}
