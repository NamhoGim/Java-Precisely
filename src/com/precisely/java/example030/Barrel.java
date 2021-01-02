package com.precisely.java.example030;
// Example 30 from page 25 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

public class Barrel extends Vessel {
    double radius, height;

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
        return "barrel (" + radius + ", " + height + ")";
    }
}
