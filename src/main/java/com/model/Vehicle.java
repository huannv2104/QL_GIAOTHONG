package com.model;

public class Vehicle {
    private int vehicleId;
    private String vehicleName;
    private String licensePlate;
    private int userId;

    public Vehicle(int vehicleId, String vehicleName, String licensePlate, int userId) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.licensePlate = licensePlate;
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getUserId() {
        return userId;
    }
}