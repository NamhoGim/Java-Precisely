package com.precisely.java.example109;

// Pseudo-random numbers and sleeping threads
public class Util {
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
