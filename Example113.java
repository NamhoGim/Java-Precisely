// Example 113 from page 87 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.io.IOException;

class Example113 {
    public static void main(String[] args) throws IOException {
        final MutableInteger mi = new MutableInteger();
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (mi.get() == 0)        // Loop while zero
                {
                }
                System.out.println("I completed, mi = " + mi.get());
            }
        });
        t.start();
        System.out.println("Press Enter to set mi to 42 and stop the loop:");
        System.in.read();                   // Wait for enter key
        mi.set(42);
        System.out.println("mi set to 42, waiting for thread ...");
        try {
            t.join();
        } catch (InterruptedException exn) {
        }
        System.out.println("Thread t completed, and so does main");
    }
}

// From Goetz et al p. 36.  WARNING: Useless without "volatile" or
// "synchronized" to ensure visibility of writes across threads.
class MutableInteger {
    private /* volatile */ int value = 0;

    public void set(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}


