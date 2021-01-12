package com.precisely.java.example060;
// Example 60 from page 45 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example60 {
    public static void main(String[] args) {
        com.precisely.java.example027.Point p = new com.precisely.java.example027.Point(10, 20);
        int[] a = new int[5];
        int d = 8;
        System.out.println("p is " + p);          // Prints: p is (10, 20)
        System.out.println("a[3] is " + a[3]);    // Prints: a[3] is 0
        m(p, d, a);
        System.out.println("p is " + p);          // Prints: p is (18, 28)
        System.out.println("d is " + d);          // Prints: d is 8
        System.out.println("a[3] is " + a[3]);    // Prints: a[3] is 22
    }

    static void m(com.precisely.java.example027.Point pp, int dd, int[] aa) {
        pp.move(dd, dd);
        dd = 117;
        aa[3] = 22;
    }
}

