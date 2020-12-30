package com.precisely.java.example024;
// Example 24 from page 21 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Example24 {
    public static void main(String[] args) {
        System.out.println("The first 50 van der Corput numbers:");
        vanDerCorput().limit(50).forEach(x -> System.out.printf("%g ", x));
        System.out.println();
        testExample24();
        vanDerCorputDensity(50_000_000);
        // One can generate and add 1 billion van der Corput numbers in 9
        // seconds CPU time on a single thread:
        System.out.println("Generating and computing average of 1 billion van der Corput numbers:");
        System.out.println(vanDerCorput().limit(1_000_000_000).average());
    }

    // Using a collector to test the distribution of generated
    // van der Corput numbers.

    public static void testExample24() {
        System.out.println("Distribution of van der Corput numbers in [0, 1]:");
        final int bins = 10;
        int[] binFrequenciesArray =
                vanDerCorput().limit(100_000_000).
                        collect(() -> new int[bins],
                                (a, x) -> {
                                    a[(int) (bins * x)]++;
                                },
                                (a1, a2) -> {
                                    for (int i = 0; i < a1.length; i++) a1[i] += a2[i];
                                });
        Arrays.stream(binFrequenciesArray).forEach(k -> System.out.printf("%d ", k));
        System.out.println();
        // Alternative approach: There is no collect(Collector<? super T,A,R>) method on
        // DoubleStream, hence use .boxed() to convert to Stream<Double>:
        // Due to the boxed() operation on every number, this is 5 times slower than the above:
        // Map<Integer, Long> binFrequencies =
        //   vanDerCorput().limit(100_000_000).boxed().collect(Collectors.groupingBy(x -> (int)(bins * x),
        //                                                                        Collectors.counting()));
        // System.out.println(binFrequencies);
    }

    // Generate n van der Corput numbers, sort them, find min and max
    // and measure the maximal distance between two neighboring numbers.

    static void vanDerCorputDensity(int n) {
        System.out.printf("Measuring van der Corput density, n = %d numbers:%n", n);
        {
            double[] vdc = vanDerCorput().limit(n).toArray();
            Timer t = new Timer();
            Arrays.sort(vdc);
            System.out.printf("Arrays.sort         count = %10d, time = %10.2f ms%n", n, t.check() * 1E3);
            double min = vdc[0], max = vdc[n - 1], maxDiff = 0.0;
            for (int i = 1; i < n; i++)
                maxDiff = Math.max(maxDiff, vdc[i] - vdc[i - 1]);
            System.out.printf("min = %g; max = %g; maxDiff = %g%n", min, max, maxDiff);
        }
        {
            double[] vdc = vanDerCorput().limit(n).toArray();
            Timer t = new Timer();
            Arrays.parallelSort(vdc);
            System.out.printf("Arrays.parallelSort count = %10d, time = %10.2f ms%n", n, t.check() * 1E3);
            double min = vdc[0], max = vdc[n - 1], maxDiff = 0.0;
            for (int i = 1; i < n; i++)
                maxDiff = Math.max(maxDiff, vdc[i] - vdc[i - 1]);
            System.out.printf("min = %g; max = %g; maxDiff = %g%n", min, max, maxDiff);
        }
    }

    // A van der Corput number stream generator that can produce a
    // sequence of length 2^31-1 in constant space.  (By extending
    // bitReverse to work for longs, presumably one can generate
    // sequences up to length 2^51 --- limited only by the size of the
    // significand in 64-bit floating-point numbers, and the precision
    // of Math.pow).

    public static DoubleStream vanDerCorput() {
        return IntStream.range(1, 31).asDoubleStream().flatMap(b -> bitReversedRange((int) b));
    }

    private static DoubleStream bitReversedRange(int b) {
        final long bp = Math.round(Math.pow(2, b));
        return LongStream.range(bp / 2, bp).mapToDouble(i -> (double) (bitReverse((int) i) >>> (32 - b)) / bp);
    }

    // Reverses the bits in a 32-bit integer as if unsigned.
    // From an answer 2009-04-14 by Matt J on Stackoverflow; originally in C:
    // http://stackoverflow.com/questions/746171/best-algorithm-for-bit-reversal-from-msb-lsb-to-lsb-msb-in-c
    private static int bitReverse(int i) {
        i = (((i & 0xaaaaaaaa) >>> 1) | ((i & 0x55555555) << 1));
        i = (((i & 0xcccccccc) >>> 2) | ((i & 0x33333333) << 2));
        i = (((i & 0xf0f0f0f0) >>> 4) | ((i & 0x0f0f0f0f) << 4));
        i = (((i & 0xff00ff00) >>> 8) | ((i & 0x00ff00ff) << 8));
        return ((i >>> 16) | (i << 16));
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

