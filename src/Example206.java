// Example 206 from page 173 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.lang.reflect.*;

class K1 {
    public int f1;
    protected int f2;

    public K1() {
    }

    public K1(int f1) {
        this.f1 = f1;
    }

    public void m1() {
        System.out.println("K1.m1()");
    }

    public void m1(int i) {
        System.out.println("K1.m1(int)");
    }

    private void m2() {
        System.out.println("K1.m2()");
    }
}

class K2 extends K1 {
    public void m3() {
        System.out.println("K2.m3()");
    }

    private void m4() {
        System.out.println("K2.m4()");
    }
}

class Example206 {
    public static void main(String[] args) {
        Class<K2> k2o = K2.class;
        System.out.println("\nK2 public methods, including inherited ones:");
        Method[] mop = k2o.getMethods();          // Gets m1() m1(int) m3() ...
        for (Method m : mop)
            System.out.println(m);
        System.out.println();

        System.out.println("K2 declared methods, including non-public ones:");
        Method[] mod = k2o.getDeclaredMethods();  // Gets m3() m4()
        for (Method m : mod)
            System.out.println(m);
        System.out.println();
    }
}
