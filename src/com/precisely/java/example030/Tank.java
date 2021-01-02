package com.precisely.java.example030;
// Example 30 from page 25 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

public class Tank extends Vessel {
    double length, width, height;

    public Tank(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double capacity() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "tank (" + length + ", " + width + ", " + height + ")";
    }
}

