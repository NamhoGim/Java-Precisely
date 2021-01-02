package com.precisely.java.example033;

public class B {                         // one non-static field vf, one static sf
    public int vf;
    public static int sf;

    B(int i) {
        vf = i;
        sf = i + 1;
    }
}
