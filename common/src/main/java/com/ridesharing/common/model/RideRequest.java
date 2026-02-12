package com.ridesharing.common.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public class RideRequest {
    
    @NotBlank
    private String requestId;
    
    @NotBlank
    private String customerId;
    
    @NotNull
    private Location pickupLocation;
    
    @NotNull
    private Location dropoffLocation;
    
    @NotNull
    private Instant requestTime;
    
    private RideType rideType;

    public RideRequest() {
        this.requestId = UUID.randomUUID().toString();
        this.requestTime = Instant.now();
        this.rideType = RideType.STANDARD;
    }

    public RideRequest(String customerId, Location pickupLocation, Location dropoffLocation) {
        this();
        this.customerId = customerId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
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

    public Instant getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Instant requestTime) {
        this.requestTime = requestTime;
    }

    public RideType getRideType() {
        return rideType;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }

    public enum RideType {
        STANDARD,
        PREMIUM,
        SHARED
    }
}
