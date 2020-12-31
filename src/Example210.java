// Example 210 from page 175 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.lang.reflect.*;

class Example210 {
    public static void main(String[] args)
            throws IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException {
        Class<K1> k1o = K1.class;
        Method m1o = k1o.getMethod("m1"),                        // Gets K1.m1()
                m1io = k1o.getMethod("m1", int.class);             // Gets K1.m1(int)
        K2 o2 = new K2();
        m1o.invoke(o2);                                          // Call o2.m1()
        m1io.invoke(o2, 117);                                    // Call o2.m1(117)
    }
}
