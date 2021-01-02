package com.precisely.java.example033;

public class C extends B {               // two non-static fields vf, one static sf
    public int vf;
    public static int sf;

    public C(int i) {
        super(i + 20);
        vf = i;
        sf = i + 2;
    }
}
