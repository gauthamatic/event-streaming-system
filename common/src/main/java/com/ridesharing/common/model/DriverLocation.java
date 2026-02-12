package com.ridesharing.common.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class DriverLocation {
    
    @NotBlank
    private String driverId;
    
    @NotNull
    private Location location;
    
    @NotNull
    private Instant timestamp;
    
    private boolean available;
    
    private String currentRideId;

    public DriverLocation() {
        this.timestamp = Instant.now();
        this.available = true;
    }

    public DriverLocation(String driverId, Location location) {
        this();
        this.driverId = driverId;
        this.location = location;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCurrentRideId() {
        return currentRideId;
    }

    public void setCurrentRideId(String currentRideId) {
        this.currentRideId = currentRideId;
    }
}
