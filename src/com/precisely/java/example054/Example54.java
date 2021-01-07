package com.precisely.java.example054;
// Example 54 from page 41 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.function.DoubleUnaryOperator;
import java.util.function.IntUnaryOperator;

class Example54 {
    public static void main(String[] args) {
        System.out.println(absolute(-12));
        System.out.println(absolute(12));
        System.out.println(absolute(0));
    }

    // Returns the absolute value of x (always non-negative)
    static double absolute(double x) {
        return x >= 0 ? x : -x;
    }

    static IntUnaryOperator doInteger(boolean flip) {
        return flip ? x -> -x : x -> x;
    }

    static DoubleUnaryOperator doDouble(boolean flip) {
        return flip ? x -> -x : x -> x;
    }
}
