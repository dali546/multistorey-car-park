package com.softwire.training.parking;

public class ParkingSpace {

    private int id;
    private double maxHeight, maxWidth;
    private Vehicle.Type typeRestriction;
    private Vehicle parkedVehicle;

    public ParkingSpace(int id, double maxHeight, double maxWidth) {
        this.id = id;
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        typeRestriction = Vehicle.Type.CAR;
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


    public void parkVehicle(Vehicle vehicle) throws IllegalArgumentException, IllegalStateException {
        if (isOccupied()) {
            throw new IllegalStateException();
        } else if (!isVehicleAllowed(vehicle)) {
            throw new IllegalArgumentException();
        } else {
            this.parkedVehicle = vehicle;
        }
    }

    public void vacate() {
        parkedVehicle = null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isOccupied() {
        return parkedVehicle != null;
    }
}
