package com.softwire.training.parking;

public class Vehicle {

    public enum Type {
        CAR,
        MOTORCYCLE,
        VAN,
    }

    private String registration;
    private double height, width;
    private Type type;

    public Vehicle(Type type, String registration, double height, double width) {
        this.type = type;
        this.registration = registration;
        this.height = height;
        this.width = width;
    }

    public String getRegistration() {
        return registration;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Type getType() {
        return type;
    }
}