// Example 61 from page 47 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example61 {
    double m(int i) {
        return i;
    }

    boolean m(boolean b) {
        return !b;
    }

    static double m(int x, double y) {
        return x + y + 1;
    }

    static double m(double x, double y) {
        return x + y + 3;
    }

    public static void main(String[] args) {
        System.out.println(m(10, 20));              // Prints 31.0
        System.out.println(m(10, 20.0));            // Prints 31.0
        System.out.println(m(10.0, 20));            // Prints 33.0
        System.out.println(m(10.0, 20.0));          // Prints 33.0
    }
}
