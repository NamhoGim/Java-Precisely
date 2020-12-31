// Example 207 from page 173 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.lang.reflect.*;

class Example207 {
    public static void main(String[] args) {
        Class<K2> k2o = K2.class;
        K2 o2 = new K2();
        Class k2o2 = o2.getClass();             // k2o == k2o2
        if (k2o == k2o2)
            System.out.println("k2o == k2o2");
        K1 o11 = new K1(), o12 = o2;            // o11.getClass() != o12.getClass()
        if (o11.getClass() != o12.getClass())
            System.out.println("o11.getClass() != o12.getClass()");
    }
}
