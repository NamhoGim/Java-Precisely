package com.precisely.java.example055;
// Example 55 from page 41 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example55 {
    public static void main(String[] args) {
        // Instance test
        Number n1 = new Integer(17);
        Number n2 = new Double(3.14);
        // The following statements print: false, true, false, true
        System.out.println("n1   is a Double: " + (n1 instanceof Double));
        System.out.println("n2   is a Double: " + (n2 instanceof Double));
        System.out.println("null is a Double: " + (null instanceof Double));
        System.out.println("n2   is a Number: " + (n2 instanceof Number));
    }
}
