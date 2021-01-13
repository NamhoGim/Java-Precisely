package com.precisely.java.example077;
// Example 77 from page 57 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example77 {
    public static void main(String[] args) {
        int[] iarr = {2, 3, 5, 7, 11};
        int sum = 0;
        for (int i : iarr)
            sum += i;
        System.out.println(sum);
    }
}
