package com.precisely.java.example006;
// Example 6 from page 9 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example6 {
    public static void main(String[] args) {
        int a, b, c;
        int x = 1, y = 2, z = 3;
        int ratio = z / x;
        final double PI = 3.141592653589;
        boolean found = false;
        final int maxyz;
        if (z > y) maxyz = z;
        else maxyz = y;
        System.out.println(maxyz);
    }
}
