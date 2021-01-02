package com.precisely.java.example030;
// Example 30 from page 25 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

public abstract class Vessel {
    double contents;

    public abstract double capacity();

    public void fill(double amount) {
        contents = Math.min(contents + amount, capacity());
    }
}

