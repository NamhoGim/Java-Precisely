// Example 33 from page 27 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class B                         // one non-static field vf, one static sf
{
    int vf;
    static int sf;

    B(int i) {
        vf = i;
        sf = i + 1;
    }
}

class C extends B               // two non-static fields vf, one static sf
{
    int vf;
    static int sf;

    C(int i) {
        super(i + 20);
        vf = i;
        sf = i + 2;
    }
}

class D extends C               // three non-static fields vf
{
    int vf;

    D(int i) {
        super(i + 40);
        vf = i;
        sf = i + 4;
    }
}
