package com.ridesharing.common.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.Duration;
import java.time.Instant;

public class RideCompleted {
    
    @NotBlank
    private String rideId;
    
    @NotBlank
    private String customerId;
    
    @NotBlank
    private String driverId;
    
    @NotNull
    private Location pickupLocation;
    
    @NotNull
    private Location dropoffLocation;
    
    @NotNull
    private Instant startTime;
    
    @NotNull
    private Instant endTime;
    
    @Positive
    private Double fare;
    
    @Positive
    private Double distance;
    
    private Long durationSeconds;
    
    private Double surgeMultiplier;

    public RideCompleted() {
        this.surgeMultiplier = 1.0;
    }

    public RideCompleted(String rideId, String customerId, String driverId, 
                        Location pickupLocation, Location dropoffLocation,
                        Instant startTime, Instant endTime, Double fare, Double distance) {
        this();
        this.rideId = rideId;
        this.customerId = customerId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.fare = fare;
        this.distance = distance;
        this.durationSeconds = Duration.between(startTime, endTime).getSeconds();
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(Location dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Double getSurgeMultiplier() {
        return surgeMultiplier;
    }

    public void setSurgeMultiplier(Double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }
}
