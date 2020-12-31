// Example 108 from page 81 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.io.*;

class Incrementer extends Thread {
    public volatile int i;

    @Override
    public void run() {
        for (; ; ) {                                    // Forever
            i++;                                        //   increment i
            yield();
        }
    }
}

class Example108 {
    public static void main(String[] args) throws IOException {
        Incrementer u = new Incrementer();
        u.start();
        System.out.println("Repeatedly press Enter to get the current value of i:");
        for (; ; ) {
            System.in.read();                         // Wait for keyboard input
            System.out.println(u.i);
        }
    }
}
