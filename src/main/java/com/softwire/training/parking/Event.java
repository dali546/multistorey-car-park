package com.softwire.training.parking;

public class Event {

    private String eventType;
    private Vehicle vehicle;
    private String registration;

    public Event(String eventType, Vehicle vehicle) {
        this.eventType = eventType;
        this.vehicle = vehicle;
    }

    public Event(String eventType, String registration){
        this.eventType = eventType;
        this.registration =registration;
    }

    public String getEventType() {
        return eventType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getRegistration() {
        return registration;
    }
}
