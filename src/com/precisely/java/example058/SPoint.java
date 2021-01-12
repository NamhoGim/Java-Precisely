package com.precisely.java.example058;
// Example 58 from page 43 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.ArrayList;

public class SPoint {
    static ArrayList<SPoint> allpoints = new ArrayList<>();
    int x, y;

    public SPoint(int x, int y) {
        allpoints.add(this);
        this.x = x;
        this.y = y;
    }

    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int getIndex() {
        return allpoints.indexOf(this);
    }

    public static int getSize() {
        return allpoints.size();
    }

    public static SPoint getPoint(int i) {
        return allpoints.get(i);
    }
}
