package com.precisely.java.example100.vessel;

public abstract class Vessel {

    private double contents;

    public abstract double capacity();

    public final void fill(double amount) {
        contents = Math.min(contents + amount, capacity());
    }

    public final double getContents() {
        return contents;
    }
}
