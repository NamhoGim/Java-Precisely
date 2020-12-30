package com.precisely.java.example026;// Example 26 from page 21 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Example26 {
    public static void main(String[] args) {
        brownian1D(10_000_000);
        brownian2D(10_000_000);
    }

    // Brownian motion in one dimension

    static void brownian1D(int n) {
        System.out.printf("Brownian motion in 1D, n = %d moves:%n", n);
        {
            double[] a = new Random().doubles(n, -1.0, +1.0).toArray();
            Timer t = new Timer();
            Arrays.parallelPrefix(a, (x, y) -> x + y);
            double maxDist = Arrays.stream(a).map(Math::abs).max().getAsDouble();
            System.out.printf("seq max   maxDist = %12g, time = %10.2f ms%n", maxDist, t.check() * 1E3);
        }
        {
            double[] a = new Random().doubles(n, -1.0, +1.0).toArray();
            Timer t = new Timer();
            Arrays.parallelPrefix(a, (x, y) -> x + y);
            double maxDist = Arrays.stream(a).parallel().map(Math::abs).max().getAsDouble();
            System.out.printf("par max   maxDist = %12g, time = %10.2f ms%n", maxDist, t.check() * 1E3);
        }
    }

    static void brownian2D(int n) {
        {
            System.out.printf("Brownian motion in 2D, n = %d moves:%n", n);
            Vec2D[] a = new Vec2D[n];
            Timer t = new Timer();
            Arrays.parallelSetAll(a, i -> Vec2D.randomUniform());
            Arrays.parallelPrefix(a, (p1, p2) -> p1.add(p2));
            double maxDist = Arrays.stream(a).mapToDouble(Vec2D::length).max().getAsDouble();
            System.out.printf("          maxDist = %12g, time = %10.2f ms%n", maxDist, t.check() * 1E3);
        }
    }

    private static class Vec2D {
        public final double x, y;

        public Vec2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double length() {
            return Math.sqrt(x * x + y * y);
        }

        public Vec2D add(Vec2D that) {
            return new Vec2D(this.x + that.x, this.y + that.y);
        }

        // It is safe to use a java.util.Random instance from multiple
        // threads, and hence to call its methods from an argument to
        // Arrays.parallelSetAll, but it is not very efficient.  Using
        // java.util.concurrent.ThreadLocalRandom gives much better
        // scalability on a multicore machine.

        private static final Random rnd = new Random();

        public static Vec2D randomUniform() {
            // Not scalable on multicore machines, see above:
            // double x = rnd.nextDouble() * 2.0 - 1.0,
            //        y = rnd.nextDouble() * 2.0 - 1.0;
            double x = ThreadLocalRandom.current().nextDouble(-1.0, +1.0),
                    y = ThreadLocalRandom.current().nextDouble(-1.0, +1.0);
            return new Vec2D(x, y);
        }
    }

    // Simple timer, measuring wall-clock (elapsed) time in seconds

    private static class Timer {
        private final long start;

        public Timer() {
            start = System.nanoTime();
        }

        public double check() {
            return (System.nanoTime() - start) / 1e9;
        }
    }
}

