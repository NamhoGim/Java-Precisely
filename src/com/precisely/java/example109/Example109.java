package com.precisely.java.example109;// Example 109 from page 83 of Java Precisely third edition (The MIT Press 2016)
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
