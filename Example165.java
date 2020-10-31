// Example 165 from page 133 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Example165 {
    public static void main(String[] args) {
        createExample165();
        System.out.println("Using Stream.forEach(...):");
        Stream<String> ss = Stream.of("Hoover", "Roosevelt", "Truman", "Eisenhower", "Kennedy");
        ss.forEach(System.out::println);
        System.out.println("\nUsing a Stream.iterator():");
        iterationExample(Stream.of("Hoover", "Roosevelt", "Truman", "Eisenhower", "Kennedy"));
        primeCountingComparison();
        showPrimes();
        testSequentialParallel();
        System.out.println("\nCreating and printing streams or lists of prime factors:");
        final int range = 10;
        Stream<IntStream> factorsImp = factorsImperative(range),
                factorsFunc = factorsFunctional(range),
                allFactors = allFactorExample165();
        Stream<IntStream> someFactors = allFactors.limit(range);
        someFactors.forEach(fs -> System.out.println(intStreamToString1(fs)));
        allFactorLists().limit(range).forEach(System.out::println);
        allFactorLists().limit(range).mapToInt(List::size).forEach(System.out::println);
        System.out.println("\nStatistics on lists of prime factors:");
        factorCollectorExamples();
        // infiniteIntExample165();
    }

    // Creating finite streams

    private static void createExample165() {
        IntStream is = IntStream.of(2, 3, 5, 7, 11, 13);
        String[] a = {"Hoover", "Roosevelt", "Truman", "Eisenhower", "Kennedy"};
        Stream<String> presidents = Arrays.stream(a);
        Collection<String> coll = new HashSet<String>();
        coll.add("Denmark");
        coll.add("Norway");
        coll.add("Sweden");
        Stream<String> countries = coll.stream();
    }

    // Creating infinite streams

    public static void infiniteIntExample165() {
        IntStream nats1 = IntStream.iterate(0, x -> x + 1);
        IntStream nats2 = IntStream.generate(new IntSupplier() {
            private int next = 0;

            public int getAsInt() {
                return next++;
            }
        });
        final int[] next = {0};
        IntStream nats3 = IntStream.generate(() -> next[0]++);
        nats3.forEach(i -> System.out.printf("%d ", i));
    }

    public static void iterationExample(Stream<String> xs) {
        // for (String x : xs)              // Illegal: xs does not implement Iterable<String>
        //   System.out.println(x);
        for (Iterator<String> iter = xs.iterator(); iter.hasNext(); ) {
            String x = iter.next();
            System.out.println(x);
        }
    }

    // Prime counting speed measurements

    private static void primeCountingComparison() {
        System.out.println("\nComparing prime counting performance:");
        int range = 10_000_000;
        System.out.printf("Counting the prime numbers in [0..%d]:%n", range);
        {
            Timer t = new Timer();
            int count = 0;
            for (int i = 0; i < range; i++)
                if (isPrime(i))
                    count++;
            System.out.printf("for-loop:   count = %10d, time = %10.2f ms%n", count, t.check() * 1E3);
        }
        {
            Timer t = new Timer();
            long count = IntStream.range(0, range).filter(i -> isPrime(i)).count();
            System.out.printf("seq stream: count = %10d, time = %10.2f ms%n", count, t.check() * 1E3);
        }
        {
            Timer t = new Timer();
            long count = IntStream.range(0, range).parallel().filter(i -> isPrime(i)).count();
            System.out.printf("par stream: count = %10d, time = %10.2f ms%n", count, t.check() * 1E3);
        }
    }

    // Collectors on prime factor lists of type Stream<List<Integer>>

    public static void factorCollectorExamples() {
        // Group integers by the number of prime factors they have, and show the groups:
        Map<Integer, List<List<Integer>>> factorGroups =
                allFactorLists().limit(11).collect(Collectors.groupingBy(List::size));
        System.out.println(factorGroups);
        // {1=[[2], [3], [5], [7], [11]], 2=[[2, 2], [2, 3], [3, 3], [2, 5]], 3=[[2, 2, 2], [2, 2, 3]]}
        // Group integers by the number of prime factors they have, then
        // count the number of members in each group:
        Map<Integer, Long> factorGroupSizes =
                allFactorLists().limit(5000).collect(Collectors.groupingBy(List::size, Collectors.counting()));
        System.out.println(factorGroupSizes);
        // {1=669, 2=1366, 3=1273, 4=832, 5=452, 6=224, 7=104, 8=47, 9=22, 10=7, 11=3, 12=1}

        // Count the number of times 2, 3, ... appear as prime factor in a
        // list of factorizations.  Presumably best to flatten the factor
        // lists into an IntStream and apply groupingBy and counting to that:
        Map<Integer, Long> factorFrequencies =
                allFactorLists().limit(11).flatMap(List::stream)
                        .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(factorFrequencies);
    }

    // Various ways to convert an IntStream to a String with a neat list-like look

    private static String intStreamToString1(IntStream is) {
        return is
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",", "[", "]"));
    }

    private static String intStreamToString2(IntStream is) {
        return is
                .boxed()
                .collect(Collectors.mapping(String::valueOf,
                        Collectors.joining(",", "[", "]")));
    }

    private static boolean isPrime(int n) {
        int k = 2;
        while (k * k <= n && n % k != 0)
            k++;
        return n >= 2 && k * k > n;
    }

    // Various ways to create a sequential stream of prime numbers

    public static void showPrimes() {
        Consumer<IntStream> print = is ->
                is.limit(20).forEach(x -> System.out.printf("%d ", x));
        System.out.println("Infinite stream, lazy functional generation");
        print.accept(primes1());
        System.out.println("\nFinite stream, lazy functional generation");
        print.accept(primes2(30));
        System.out.println("\nInfinite stream, lazy stateful generation");
        print.accept(primes3());
        System.out.println("\nFinite stream, eager imperative generation");
        print.accept(primes4(30));
        System.out.println();
    }

    // A sequential infinite stream of primes, lazily built
    public static IntStream primes1() {
        IntStream nats = IntStream.iterate(0, x -> x + 1);
        IntStream primes = nats.filter(x -> isPrime(x));
        return primes;
    }

    // A sequential finite stream of the first n primes, lazily built
    public static IntStream primes2(int n) {
        return IntStream.iterate(0, x -> x + 1).filter(x -> isPrime(x)).limit(n);
    }

    // A sequential infinite stream of the first n primes, lazily built
    public static IntStream primes3() {
        final int[] p = {0};
        IntSupplier primeGenerator =
                () -> {
                    while (!isPrime(p[0]))
                        p[0]++;
                    System.out.printf("[%d]", p[0]);
                    return p[0]++;
                };
        return IntStream.generate(primeGenerator);
    }

    // A sequential finite stream of the first n primes, eagerly built
    public static IntStream primes4(int n) {
        IntStream.Builder isb = IntStream.builder();
        int p = 0, count = 0;
        while (count < n) {
            if (isPrime(p)) {
                System.out.printf("[%d]", p);
                isb.accept(p);
                count++;
            }
            p++;
        }
        return isb.build();
    }

    // Various ways to create a stream of the set of prime factors of
    // the natural numbers

    public static List<Integer> factorList(int p) {
        List<Integer> result = new ArrayList<Integer>();
        int k = 2;
        while (p >= k * k) {
            if (p % k == 0) {
                result.add(k);
                p /= k;
            } else
                k++;
        }
        // Now p < k * k and no number in 2..k divides p
        if (p > 1)
            result.add(p);
        return result;
    }

    public static IntStream factorStream(int p) {
        IntStream.Builder isb = IntStream.builder();
        int k = 2;
        while (p >= k * k) {
            if (p % k == 0) {
                isb.accept(k);
                p /= k;
            } else
                k++;
        }
        // Now p < k * k and no number in 2..k divides p
        if (p > 1)
            isb.accept(p);
        return isb.build();
    }

    // Shows how to get from Stream<Integer> to IntStream
    public static IntStream factorStreamFromList(int p) {
        return factorList(p).stream().mapToInt(Integer::intValue);
    }

    // Finite stream of streams of prime factors, built imperatively and
    // eagerly
    public static Stream<IntStream> factorsImperative(int range) {
        Stream.Builder<IntStream> sb = Stream.builder();
        for (int p = 2; p < range; p++)
            sb.accept(factorStream(p));
        return sb.build();
    }

    // Finite stream of streams of prime factors, built lazily
    public static Stream<IntStream> factorsFunctional(int range) {
        return IntStream.range(2, range).mapToObj(Example165::factorStream);
    }

    // Infinite stream of streams of prime factors.  Seems impossible to
    // make it using an IntStream.Builder, but can make it from an
    // IntSupplier or more functionally, using iterate:
    public static Stream<IntStream> allFactorExample165() {
        IntStream allNats1 = IntStream.iterate(2, x -> x + 1);
        return allNats1.mapToObj(Example165::factorStream);
    }

    public static Stream<List<Integer>> allFactorLists() {
        return IntStream.iterate(2, x -> x + 1).mapToObj(Example165::factorList);
    }

    public static void testSequentialParallel() {
        System.out.println(isSorted2(IntStream.of(2, 5, 3, 7)));
        Random rnd = new Random();
        // Make random sequential stream, sort it, and test it; should be true
        System.out.printf("true  = %b%n",
                isSorted2(rnd.ints(100000).sorted()));
        // Make random parallel stream, sort it, and test it; most likely false
        System.out.printf("false = %b%n",
                isSorted2(rnd.ints(100000).parallel().sorted()));
        // Make random parallel stream, sort it, make it sequential, and test it; should be true
        System.out.printf("true  = %b%n",
                isSorted2(rnd.ints(100000).parallel().sorted().sequential()));
        // Make increasing sequential stream and test it; should be true
        System.out.printf("true  = %b%n",
                isSorted2(IntStream.range(1, 100000)));
        // Make increasing parallel stream and test it; most likely false
        System.out.printf("false = %b%n",
                isSorted2(IntStream.range(1, 100000).parallel()));
        // Make increasing parallel stream, multiply by 2 in parallel,
        // then sequentialize and test it; should be true
        System.out.printf("true  = %b%n",
                isSorted2(IntStream.range(1, 100000).parallel().map(x -> 2 * x).sequential()));
    }

    // Various ways to test sortedness of an IntStream

    // This abomination works, on a sequential stream, not a parallel one
    static boolean isSorted1(IntStream xs) {
        final int[] last = new int[1];
        last[0] = Integer.MIN_VALUE;
        try {
            xs.forEach(x -> {
                if (last[0] > x)
                    throw new RuntimeException();
                else
                    last[0] = x;
            });
        } catch (RuntimeException exn) {
            return false;
        }
        return true;
    }

    // This should work for sequential streams, although the predicate
    // is stateful.
    static boolean isSorted2(IntStream xs) {
        final int[] last = {Integer.MIN_VALUE};
        return xs.allMatch(x -> {
            int old = last[0];
            last[0] = x;
            return old <= x;
        });
    }

    // This should work for sequential streams, although the predicate
    // is stateful.  Note the daring exploitation of Java left-to-right
    // evaluation in the predicate.
    static boolean isSorted3(IntStream xs) {
        final int[] last = {Integer.MIN_VALUE};
        return xs.allMatch(x -> last[0] <= (last[0] = x));
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


