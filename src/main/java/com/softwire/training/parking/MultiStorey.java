package com.softwire.training.parking;

import java.util.*;
import java.util.stream.Collectors;

public class MultiStorey {

    private List<Floor> floors;


    public MultiStorey(Floor... floors) {
        this.floors = Arrays.asList(floors);
    }


    public ParkingSpace getNearestSpaceForVehicle(Vehicle vehicle) {
        return floors.stream()
                .sorted(Comparator.comparing(Floor::getFloorNumber))
                .map(floor -> floor.getNearestFreeSpaceForVehicle(vehicle))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
