package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double optimizedDistanceKm;

    private Double estimatedFuelUsageL;

    private LocalDateTime generatedAt;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    // -------- Constructors --------

    public RouteOptimizationResult() {
        this.generatedAt = LocalDateTime.now();
    }

    public RouteOptimizationResult(Long id,
                                   Double optimizedDistanceKm,
                                   Double estimatedFuelUsageL,
                                   LocalDateTime generatedAt,
                                   Shipment shipment) {
        this.id = id;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
        this.shipment = shipment;
    }

    // -------- Getters & Setters --------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getOptimizedDistanceKm() { return optimizedDistanceKm; }
    public void setOptimizedDistanceKm(Double optimizedDistanceKm) {
        this.optimizedDistanceKm = optimizedDistanceKm;
    }

    public Double getEstimatedFuelUsageL() { return estimatedFuelUsageL; }
    public void setEstimatedFuelUsageL(Double estimatedFuelUsageL) {
        this.estimatedFuelUsageL = estimatedFuelUsageL;
    }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Shipment getShipment() { return shipment; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }

    // -------- Manual Builder (REQUIRED BY TESTS) --------

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Long id;
        private Double optimizedDistanceKm;
        private Double estimatedFuelUsageL;
        private LocalDateTime generatedAt;
        private Shipment shipment;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder optimizedDistanceKm(Double optimizedDistanceKm) {
            this.optimizedDistanceKm = optimizedDistanceKm;
            return this;
        }

        public Builder estimatedFuelUsageL(Double estimatedFuelUsageL) {
            this.estimatedFuelUsageL = estimatedFuelUsageL;
            return this;
        }

        public Builder generatedAt(LocalDateTime generatedAt) {
            this.generatedAt = generatedAt;
            return this;
        }

        public Builder shipment(Shipment shipment) {
            this.shipment = shipment;
            return this;
        }

        public RouteOptimizationResult build() {
            return new RouteOptimizationResult(
                    id,
                    optimizedDistanceKm,
                    estimatedFuelUsageL,
                    generatedAt != null ? generatedAt : LocalDateTime.now(),
                    shipment
            );
        }
    }
}
