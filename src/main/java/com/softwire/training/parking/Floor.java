package com.softwire.training.parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Floor {

    private int floorNumber;
    private int capacity;
    private List<ParkingSpace> parkingSpaces;


    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        parkingSpaces = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    public void addParkingSpace(ParkingSpace parkingSpace) {
        parkingSpaces.add(parkingSpace);
        capacity++;
    }

    public int getNumberOfFreeSpaces() {
        return (int) parkingSpaces.stream().filter(ParkingSpace::isOccupied).count();
    }

    public ParkingSpace getNearestFreeSpaceForVehicle(Vehicle vehicle) {
        // TODO - replace this!
        return null;
    }
}
