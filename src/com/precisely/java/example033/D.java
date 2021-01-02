package com.precisely.java.example033;
// Example 33 from page 27 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

public class D extends C {               // three non-static fields vf
    public int vf;

    public D(int i) {
        super(i + 40);
        vf = i;
        sf = i + 4;
    }
}
