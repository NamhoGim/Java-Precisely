package com.precisely.java.example107;
// Example 107 from page 79 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.text.DecimalFormat;

// Padding a String to a Given Width
class Example107 {
    public static void main(String[] args) {
        System.out.println("Printing temperature table");
        DecimalFormat ff = new DecimalFormat("#0"), cf = new DecimalFormat("0.0");
        System.out.println("Fahrenheit   Celsius");
        for (double f = 100; f <= 400; f += 10) {
            double c = 5 * (f - 32) / 9;
            System.out.println(padLeft(ff.format(f), 10) + padLeft(cf.format(c), 10));
        }
    }

    static String padLeft(String s, int width) {
        StringBuilder res = new StringBuilder();
        for (int i = width - s.length(); i > 0; i--)
            res.append(' ');
        return res.append(s).toString();
    }
}
