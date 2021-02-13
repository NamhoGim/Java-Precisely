package com.precisely.java.example100.vessel;

public class Cube extends Tank {

    public Cube(double side) {
        super(side, side, side);
    }

    public String toString() {
        return "Cude (s) = (" + length + ")";
    }
}
