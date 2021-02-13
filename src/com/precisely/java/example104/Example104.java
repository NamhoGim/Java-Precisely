package com.precisely.java.example104;
// Example 104 from page 79 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

// Efficiently Concatenating All Command Line Arguments
class Example104 {
    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            res.append(args[i]);
        System.out.println(res.toString());
    }
}
