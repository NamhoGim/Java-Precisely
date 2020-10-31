// Example 211 from page 175 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.lang.reflect.*;

class Example211 {
    public static void main(String[] args)
            throws IllegalAccessException,
            InstantiationException,
            InvocationTargetException,
            NoSuchMethodException {
        Class<K1> k1o = K1.class;
        Constructor<K1> ck1o = k1o.getConstructor(int.class);    // Gets K1(int)
        Constructor cco = ck1o;
        K1 k11 = ck1o.newInstance(42);                           // Compile-time type K1
        Object k12 = cco.newInstance(56);                        // Compile-time type Object
    }
}
