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

    // ---------- Constructors ----------
    public Location() {}

    // ---------- Builder ----------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Location location = new Location();

        public Builder id(Long id) {
            location.setId(id);
            return this;
        }

        public Builder name(String name) {
            location.setName(name);
            return this;
        }

        public Builder latitude(Double latitude) {
            location.setLatitude(latitude);
            return this;
        }

        public Builder longitude(Double longitude) {
            location.setLongitude(longitude);
            return this;
        }

        public Location build() {
            return location;
        }
    }

    // ---------- Getters & Setters ----------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
