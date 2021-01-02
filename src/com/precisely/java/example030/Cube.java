package com.precisely.java.example030;
// Example 30 from page 25 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

public class Cube extends Tank {
    public Cube(double side) {
        super(side, side, side);
    }

    @Override
    public String toString() {
        return "cube (" + length + ")";
    }
}
