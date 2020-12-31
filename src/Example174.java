// Example 174 from page 137 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.IntStream.Builder;
import java.util.stream.Stream;
import java.util.BitSet;
import java.util.Optional;

class Example174 {
    public static void main(String[] args) {
        System.out.println("\nThe first 20 permutations of 8 numbers:");
        Stream<IntList> permutations = perms(8);
        permutations.limit(20).forEach(System.out::println);
        System.out.println("\nAll solutions to the 8-queens problem:");
        Stream<IntList> queens = queens(8);
        queens(8).forEach(System.out::println);
        System.out.println("\nThe number of solutions to the 8-queens problem:");
        System.out.println(queens(8).count());
        System.out.println("\nSome solution to the 8-queens problem:");
        System.out.println(queens(8).findAny());
        countSolutions();
        findAnySolution();
    }

    public static void countSolutions() {
        System.out.println("\nSolution counts for the n-queens problem:");
        for (int n = 1; n <= 13; n++) {
            Timer t = new Timer();
            long count = queens(n).count();
            System.out.printf("%4d-queens solutions: %10d (time %12.3f sec)%n", n, count, t.check());
        }
    }

    public static void findAnySolution() {
        System.out.println("\nSome solution to the n-queens problem, if any:");
        Timer t = new Timer();
        for (int n = 1; n <= 13; n++) {
            Optional<IntList> solution = queens(n).findAny();
            System.out.printf("%4d-queens solution: %s%n", n, solution);
        }
        System.out.printf("Time %12.3f sec%n", t.check());
    }

    // It is necessary to box the IntStream produced by todo.stream()
    // because there is no object-producing version flatMapToObject on
    // IntStream!

    public static Stream<IntList> perms(BitSet todo, IntList tail) {
        if (todo.isEmpty())
            return Stream.of(tail);
        else
            return todo.stream().boxed().flatMap(r -> perms(minus(todo, r), new IntList(r, tail)));
    }

    public static Stream<IntList> queens(BitSet todo, IntList tail) {
        if (todo.isEmpty())
            return Stream.of(tail);
        else
            return todo.stream()
                    .filter(r -> safe(r, tail)).boxed() // .parallel()
                    .flatMap(r -> queens(minus(todo, r), new IntList(r, tail)));
    }

    public static boolean safe(int mid, IntList tail) {
        return safe(mid + 1, mid - 1, tail);
    }

    public static boolean safe(int d1, int d2, IntList tail) {
        return tail == null || d1 != tail.item && d2 != tail.item && safe(d1 + 1, d2 - 1, tail.next);
    }

    public static Stream<IntList> perms(int n) {
        BitSet todo = new BitSet(n);
        todo.flip(0, n);
        return perms(todo, null);
    }

    public static Stream<IntList> queens(int n) {
        BitSet todo = new BitSet(n);
        todo.flip(0, n);
        return queens(todo, null);
    }

    // This helper method is needed because Java does (yet?) support
    // immutable data structures: those for which operations create a
    // new value instead of destructively updating an existing one.

    public static BitSet minus(BitSet set, int bit) {
        BitSet rest = (BitSet) set.clone();
        rest.set(bit, false);
        return rest;
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

    // Immutable integer lists; Java is still lacking such things

    static class IntList {
        public final int item;
        public final IntList next;

        public IntList(int item, IntList next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return stream(this).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        }

        public static IntStream stream(IntList xs) {
            IntStream.Builder sb = IntStream.builder();
            while (xs != null) {
                sb.accept(xs.item);
                xs = xs.next;
            }
            return sb.build();
        }
    }
}

