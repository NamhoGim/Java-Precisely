package com.precisely.java.example070;
// Example 70 from page 53 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example70 {
    public static void main(String[] args) {
        System.out.println("Infinite loop!  Stop it by pressing ctrl-C\n\n");
        int i = 0;
        while (i < 10) ;
        i++;
    }
}
