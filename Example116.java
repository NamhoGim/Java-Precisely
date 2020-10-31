// Example 116 from page 89 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.*;

class Example116 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList cool = new ArrayList();
        cool.add(new Person("Kristen"));
        cool.add(new Person("Bjarne"));
        cool.add(new Exception("Larry"));   // Wrong, but no compile-time check
        cool.add(new Person("Anders"));
        Person p = (Person) (cool.get(2));   // Compiles OK, but fails at run-time
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

