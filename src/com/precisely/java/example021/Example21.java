package com.precisely.java.example021;
// Example 21 from page 17 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.Random;

class Example21 {
    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("Usage: java com.precisely.java.example021.Example21 <length>\n");
        else {
            System.out.println("Timing character replacement in a string:");
            Random rnd = new Random();
            int length = Integer.parseInt(args[0]);
            char[] cbuf = new char[length];
            for (int i = 0; i < length; i++)
                cbuf[i] = (char) (65 + rnd.nextInt(26));
            String s = new String(cbuf);
            for (int i = 0; i < 10; i++) {
                Timer t = new Timer();
                String res = replaceCharChar(s, 'A', 'H');
                System.out.print(t.check() + " ");
            }
            System.out.println();
        }
    }

    // Creating a String from a Character Array
    static String replaceCharChar(String s, char c1, char c2) {
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c1)
                res[i] = c2;
            else
                res[i] = s.charAt(i);
        return new String(res);
    }

    // Simple timer, measuring wall-clock (elapsed) time in seconds
    private final static class Timer {
        private final long start;

        public Timer() {
            start = System.nanoTime();
        }

        public double check() {
            return (System.nanoTime() - start) / 1e9;
        }
    }
}
