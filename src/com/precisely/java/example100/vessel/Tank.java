package com.precisely.java.example100.vessel;

public class Tank extends Vessel {
    protected final double length, width, height;

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
        return "tank (l,w,h) = (" + length + ", " + width + ", " + height + ")";
    }
}
