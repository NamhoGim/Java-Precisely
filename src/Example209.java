// Example 209 from page 175 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.lang.reflect.*;

class Example209 {
    public static void main(String[] args)
            throws IllegalAccessException, NoSuchFieldException {
        Class<K2> k2o = K2.class;
        Field f1o = k2o.getField("f1");
        K2 o2 = new K2();
        f1o.set(o2, 117);
        System.out.format("Value of o2.f1 = %d%n", f1o.get(o2)); // Gets o2.f1
        Class<K1> k1o = K1.class;
        Field f21 = k1o.getDeclaredField("f2");
        Field f22 = k1o.getField("f2");             // Throws NoSuchFieldException
        Field f23 = k2o.getField("f2");             // Throws NoSuchFieldException
        Field f24 = k2o.getDeclaredField("f2");     // Throws NoSuchFieldException
    }
}
