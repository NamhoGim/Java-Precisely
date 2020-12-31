// Example 160 from page 129 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.math.BigInteger;

// Convert a long integer between -999_999_999_999 and
// +999_999_999_999 to an English numeral.

// For instance, Integer.MIN_VALUE is minus two billion one hundred
// forty-seven million four hundred eighty-three thousand six hundred
// forty-eight

class Example160 {
    public static void main(String[] args) {
        System.out.printf("Integer.MAX_VALUE = %s%n%n", toEnglish(Integer.MAX_VALUE));
        System.out.printf("Integer.MIN_VALUE = %s%n%n", toEnglish(Integer.MIN_VALUE));
        System.out.println("The Fibonacci numbers:");
        infiniteFibonacciStream();
        // The infinite stream of numerals "zero", "one", "two", "three", ...
        Stream<String> numerals
                = LongStream.iterate(0, x -> x + 1).mapToObj(Example160::toEnglish);
        // numerals.forEach(System.out::println);
        // The infinite stream of logorithms 4, 3, 3, 5, ...
        IntStream logorithms = numerals.mapToInt(String::length);
        //     logorithms.forEach(i -> System.out.printf("%d ", i));
        System.out.println();
        System.out.println("The maximal logorithm of n <= 1_000_000 is:");
        System.out.println(logorithms.limit(1_000_000).max());
        System.out.println("\nFive ways to compose Example160::toEnglish and String::length:");
        int enough = 35;
        Supplier<Stream<Long>> nats = () -> LongStream.range(1, enough).boxed();
        nats.get().map(Example160::toEnglish).map(String::length).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        // Illegal: The method reference expression Example160::toEnglish
        // must appear in assignment context, invocation context, or
        // casting context:
        // nats.get().map(Example160::toEnglish.andThen(x -> length(x))).forEach(x -> System.out.printf("%d ", x));
        traverse1(nats.get(), Example160::toEnglish, String::length).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        traverse2(nats.get(), Example160::toEnglish, String::length).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        traverse3(nats.get(), Example160::toEnglish, String::length).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        wildcardDemo();
    }

    // ----------------------------------------------------------------------

    // Converting a long to the corresponding English numeral:

    private static final String[]
            ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"},
            tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static String less100(long n) {
        return n < 20 ? ones[(int) n] : tens[(int) n / 10 - 2] + after("-", ones[(int) n % 10]);
    }

    // Preconditions: n < limit * limit, and conv.apply(i) works for all i < limit
    private static LongFunction<String> less(long limit, String unit, LongFunction<String> conv) {
        return n -> n < limit ? conv.apply(n)
                : conv.apply(n / limit) + " " + unit + after(" ", conv.apply(n % limit));
    }

    private static String after(String d, String s) {
        return s.equals("") ? "" : d + s;
    }

    private static final LongFunction<String>
            less1K = less(100, "hundred", Example160::less100),
            less1M = less(1_000, "thousand", less1K),
            less1B = less(1_000_000, "million", less1M),
            less1G = less(1_000_000_000, "billion", less1B);

    public static String toEnglish(long n) {
        return n == 0 ? "zero" : n < 0 ? "minus " + less1G.apply(-n) : less1G.apply(n);
    }

    // Hand-fusion of traversals

    public static <T, U, V> Stream<V> traverse1(Stream<T> xs, Function<T, U> f, Function<U, V> g) {
        return xs.map(f).map(g);
    }

    public static <T, U, V> Stream<V> traverse2(Stream<T> xs, Function<T, U> f, Function<U, V> g) {
        return xs.map(f.andThen(g));
    }

    public static <T, U, V> Stream<V> traverse3(Stream<T> xs,
                                                Function<? super T, ? extends U> f,
                                                Function<? super U, ? extends V> g) {
        return xs.map(f.andThen(g));
    }

    // The utility of wildcard types

    public static void wildcardDemo() {
        int enough = 35;
        Stream<Long> nats = LongStream.range(1, enough).boxed();
        Function<Number, String> toEnglish = (Number n) -> toEnglish((long) n);
        Function<Object, Integer> length = (Object o) -> ((String) o).length();
        // Stream<Double> res = traverse2(nats, toEnglish, length);               // Type error!
        Stream<Integer> res = traverse3(nats, toEnglish, length);
        res.forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }

    public static void infiniteIntStreams() {
        IntStream nats1 = IntStream.iterate(0, x -> x + 1);
        IntStream nats2 = IntStream.generate(new IntSupplier() {
            private int next = 0;

            public int getAsInt() {
                return next++;
            }
        });
        final int[] next = {0};                // next is final, its element mutable by the lambda
        IntStream nats3 = IntStream.generate(() -> next[0]++);
        nats3.forEach(i -> System.out.printf("%d ", i));
    }

    public static void infiniteFibonacciStream() {
        final BigInteger[] fib = {BigInteger.ZERO, BigInteger.ONE};   // fib is final, its elements mutable
        Stream<BigInteger> fibonaccis =
                Stream.generate(() -> {
                    BigInteger f1 = fib[1];
                    fib[1] = fib[0].add(fib[1]);
                    return fib[0] = f1;
                });
        // Can generate very large Fibonacci numbers:
        // fibonaccis.forEach(System.out::println);
        // The Fibonacci numbers below 1 trillion, in English:
        fibonaccis.limit(59).map(b -> toEnglish(b.longValue())).forEach(System.out::println);
    }
}

