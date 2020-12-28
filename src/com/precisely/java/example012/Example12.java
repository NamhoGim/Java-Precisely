package com.precisely.java.example012;
// Example 12 from page 11 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import com.precisely.java.example027.Point;

class Example12 {
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(30, 40);
        System.out.println("p1 is " + p1);        // Prints: p1 is (10, 20)
        System.out.println("p2 is " + p2);        // Prints: p2 is (30, 40)
        p2.move(7, 7);
        System.out.println("p2 is " + p2);        // Prints: p2 is (37, 47)
    }
}

