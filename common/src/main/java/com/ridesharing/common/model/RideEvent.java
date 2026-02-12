package com.ridesharing.common.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public class RideEvent {
    
    @NotBlank
    private String rideId;
    
    @NotBlank
    private String requestId;
    
    @NotBlank
    private String customerId;
    
    @NotBlank
    private String driverId;
    
    @NotNull
    private Location pickupLocation;
    
    @NotNull
    private Location dropoffLocation;
    
    @NotNull
    private RideStatus status;
    
    @NotNull
    private Instant eventTime;
    
    private Double estimatedFare;

    public RideEvent() {
        this.eventTime = Instant.now();
    }

    public RideEvent(String rideId, String requestId, String customerId, String driverId, 
                     Location pickupLocation, Location dropoffLocation, RideStatus status) {
        this();
        this.rideId = rideId;
        this.requestId = requestId;
        this.customerId = customerId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.status = status;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public Instant getEventTime() {
        return eventTime;
    }

    public void setEventTime(Instant eventTime) {
        this.eventTime = eventTime;
    }

    public Double getEstimatedFare() {
        return estimatedFare;
    }

    public void setEstimatedFare(Double estimatedFare) {
        this.estimatedFare = estimatedFare;
    }

    public enum RideStatus {
        MATCHED,
        DRIVER_ARRIVED,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED
    }
}
