// Example 109 from page 83 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)


class Printer extends Thread {
    final static Object mutex = new Object();

    @Override
    public void run() {
        for (; ; ) {
            synchronized (mutex) {
                System.out.print("-");
                Util.pause(100, 300);
                System.out.print("/");
            }
            Util.pause(200);
        }
    }
}

class Example109 {
    public static void main(String[] args) {
        new Printer().start();
        new Printer().start();
    }
}

// Pseudo-random numbers and sleeping threads

class Util {
    public static void pause(int length) {
        try {
            Thread.sleep(length);
        } catch (InterruptedException x) {
        }
    }

    public static void pause(int a, int b) {
        pause(random(a, b));
    }

    public static int random(int a, int b) {
        return (int) (a + (b - a + 1) * Math.random());
    }
}

