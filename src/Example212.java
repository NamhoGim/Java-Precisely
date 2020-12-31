// Example 212 from page 175 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.lang.reflect.*;

class Example212 {
    public static void main(String[] args) {
        Class<K2> k2o = K2.class;
        Method[] mod = k2o.getDeclaredMethods();  // Gets m3() m4()
        System.out.println("\nK2 private methods:");
        for (Method m : mod)
            if (Modifier.isPrivate(m.getModifiers()))
                System.out.println(m);
        for (Method m : mod)
            if ((Modifier.PRIVATE & m.getModifiers()) != 0)
                System.out.println(m);
    }
}
