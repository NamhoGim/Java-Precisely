package com.precisely.java.example100.vessel;

public class Barrel extends Vessel {
    protected final double radius, height;

    public Barrel(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double capacity() {
        return height * Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "barrel (r,h) = (" + radius + ", " + height + ")";
    }
}
