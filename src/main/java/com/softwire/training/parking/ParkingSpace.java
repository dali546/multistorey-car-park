package com.softwire.training.parking;

public class ParkingSpace {

    private int id;
    private double maxHeight, maxWidth;
    private Vehicle.Type typeRestriction;

    public ParkingSpace(int id, double maxHeight, double maxWidth) {
        this.id = id;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }

    public ParkingSpace(int id, double maxHeight, double maxWidth, Vehicle.Type typeRestriction) {
        this.id = id;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.typeRestriction = typeRestriction;
    }


    public boolean isVehicleAllowed(Vehicle vehicle) {
        return vehicle.getType() == typeRestriction && vehicle.getHeight() <= maxHeight && vehicle.getWidth() <= maxWidth;
    }

    public int getId() {
        return id;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getMaxWidth() {
        return maxWidth;
    }

    public Vehicle.Type getTypeRestriction() {
        return typeRestriction;
    }

    public void parkVehicle(Vehicle vehicle) throws IllegalArgumentException, IllegalStateException {
        // TODO - replace this!
    }

    public void vacate() {
        // TODO - replace this!
    }

    public Vehicle getParkedVehicle() {
        // TODO - replace this!
        return null;
    }

    public boolean isOccupied() {
        // TODO - replace this!
        return false;
    }
}
