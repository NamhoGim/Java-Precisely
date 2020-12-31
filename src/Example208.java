// Example 208 from page 173 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.lang.reflect.*;

class Example208 {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException {
        Class<K2> k2o = K2.class;
        K2 o2 = new K2();
        K1 o11 = new K1(), o12 = o2;     // o11.getClass() != o12.getClass()
        K2 o21 = k2o.newInstance();      // OK: k2o has type Class<K2>, K2() exists
        if (k2o.isInstance(o12))         // true
            System.out.println("o12 is instance of K2");
        if (k2o.isInstance(o11))         // false
            System.out.println("o11 is instance of K2");

        K2 k22 = k2o.cast(o12);          // succeeds at run-time: o12 can be cast to K2
        System.out.println("Cast of o12 to K2 succeeded");
        K2 k23 = k2o.cast("foo");        // fails at run-time
    }
}
