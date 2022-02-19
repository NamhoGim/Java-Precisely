package com.precisely.java.example114;// Example 114 from page 87 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// C# example from Ostrovsky: The C# Memory Model in Theory and
// Practice, in MSDN Magazine, part 2 (January 2013); test harness by
// Jacob Thamsborg; Java version by sestoft@itu.dk 2015-02-27

class Example114 {
    public static void main(String[] args) throws Exception {
        final ExecutorService executor = Executors.newWorkStealingPool();
        final int numberOfAttempts = 1000000;
        final int[][] wins = {{0, 0}, {0, 0}};
        System.out.printf("Running %d experiments:%n", numberOfAttempts);
        for (int count = 0; count < numberOfAttempts; count++) {
            StoreBufferExample sharedState = new StoreBufferExample();
            Future f1 = executor.submit(() -> {
                sharedState.ThreadA();
            });
            Future f2 = executor.submit(() -> {
                sharedState.ThreadB();
            });
            f1.get();
            f2.get();
            wins[sharedState.A_Won][sharedState.B_Won]++;
        }
        System.out.printf("No one   won: %8d%n", wins[0][0]);
        System.out.printf("A        won: %8d%n", wins[1][0]);
        System.out.printf("B        won: %8d%n", wins[0][1]);
        System.out.printf("Both (!) won: %8d%n", wins[1][1]);
    }
}

class StoreBufferExample {
    public /* volatile */ boolean A = false, B = false;
    public int A_Won = 0, B_Won = 0;

    public void ThreadA() {
        A = true;
        if (!B)
            A_Won = 1;
    }

    public void ThreadB() {
        B = true;
        if (!A)
            B_Won = 1;
    }
}

// Results from Java 1.8.0_11 on Intel i7, with volatile:
// No one   won:     2668
// A        won:   438518
// B        won:   558814
// Both (!) won:        0

// Results from Java 1.8.0_11 on Intel i7, without volatile:
// No one   won:        0
// A        won:   436649
// B        won:   550463
// Both (!) won:    12888

