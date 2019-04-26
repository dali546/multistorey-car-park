package com.softwire.training.parking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.softwire.training.parking.Main.LOGGER;

public class LoadCardPark {
    static MultiStorey fromCSV(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        return createCarPark(createFloors(lines));
    }

    private static MultiStorey createCarPark(Floor... floors) {
        return new MultiStorey(floors);
    }

    private static void convertLineToParkingSpaceAndAddToFloor(String line, List<Floor> floors) {
        LOGGER.debug("Now adding parking spaces to Floors...");
        String[] split = line.split(",");
        final ParkingSpace space;
        switch (split[4]) {
            case "CAR":
                space = new ParkingSpace(
                        Integer.parseInt(split[1]),
                        Double.parseDouble(split[2]),
                        Double.parseDouble(split[3]),
                        Vehicle.Type.CAR);
                break;
            case "MOTORCYCLE":
                space = new ParkingSpace(
                        Integer.parseInt(split[1]),
                        Double.parseDouble(split[2]),
                        Double.parseDouble(split[3]),
                        Vehicle.Type.MOTORCYCLE);
                break;
            case "VAN":
                space = new ParkingSpace(
                        Integer.parseInt(split[1]),
                        Double.parseDouble(split[2]),
                        Double.parseDouble(split[3]),
                        Vehicle.Type.VAN);
                break;
            case "no restriction":
            default:
                space = new ParkingSpace(
                        Integer.parseInt(split[1]),
                        Double.parseDouble(split[2]),
                        Double.parseDouble(split[3]));
        }
        floors.stream()
                .filter(floor -> floor.getFloorNumber() == Integer.parseInt(split[0]))
                .forEach(floor -> floor.addParkingSpace(space));
    }

    private static Floor[] createFloors(List<String> lines) {
        lines.remove(0); //Remove header line
        int maxFloor = lines.stream().mapToInt(s -> Integer.parseInt(s.split(",")[0])).max().getAsInt();

        List<Floor> floors = IntStream.rangeClosed(0, maxFloor).mapToObj(Floor::new).collect(Collectors.toList());
        LOGGER.debug("Created Floors for Car Park. Car Park has {} floors.", floors.size());
        lines.forEach((String line) -> convertLineToParkingSpaceAndAddToFloor(line, floors));
        LOGGER.debug("Loaded All Floors.");
        return floors.toArray(new Floor[0]);
    }

}
