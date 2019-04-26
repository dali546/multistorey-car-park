package com.softwire.training.parking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {

    public static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws IOException {
        LOGGER.info("Application Started.");
        LOGGER.info("Initialising Car Park.");
        MultiStorey multiStorey = LoadCardPark.fromCSV("spaces.csv");

        LOGGER.info("Loading Events from file.");
        List<Event> events = ReadEvents.read("events.txt");
        for (Event event : events) {
            if (event.getEventType().equalsIgnoreCase("Entry")) {
                LOGGER.debug("A vehicle has entered. Vehicle Reg: {}. Height: {}. Width: {}",
                        event.getVehicle().getRegistration(),
                        event.getVehicle().getHeight(),
                        event.getVehicle().getWidth());
                multiStorey.getNearestSpaceForVehicle(event.getVehicle());
            } else {
                multiStorey.getSpaceContainingVehicleWithRegistration(event.getRegistration());
                LOGGER.debug("A vehicle has exited. Vehicle Reg: {}.", event.getRegistration());
            }
        }
    }
}

