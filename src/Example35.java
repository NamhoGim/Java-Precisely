// Example 35 from page 27 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Access {
    private static int x;

    static class SI {
        private static final int y = x;       // access private x from enclosing class
    }

    static void m() {
        int z = SI.y;                   // access private y from nested class
    }
}
