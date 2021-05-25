package com.precisely.java.example117;
// Example 117 from page 89 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.*;

class Example117 {
    public static void main(String[] args) {
        ArrayList<Person> cool = new ArrayList<Person>();
        cool.add(new Person("Kristen"));
        cool.add(new Person("Bjarne"));
        //   cool.add(new Exception("Larry"));   // Wrong, detected at compile-time
        cool.add(new Person("Anders"));
        Person p = cool.get(2);                  // No explicit cast or check needed
    }

    private static class Person {
        private static int counter = 0;
        private final String name;
        private final int serialNumber;

        public Person(String name) {
            this.name = name;
            this.serialNumber = counter++;
        }
    }
}
