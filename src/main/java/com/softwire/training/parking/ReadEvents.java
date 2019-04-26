package com.softwire.training.parking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadEvents {

    static List<Event> read(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<Event> events = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split(",");
            if (split[0].equalsIgnoreCase("Entry")) {

                Vehicle vehicle = new Vehicle(
                        Vehicle.Type.valueOf(split[1]),
                        split[2],
                        Double.parseDouble(split[3]),
                        Double.parseDouble(split[4]));
                events.add(new Event(split[0], vehicle));
            } else {
                events.add(new Event(split[0], split[1]));
            }
        }
        return events;
    }
}
