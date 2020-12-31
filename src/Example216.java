// Example 216 from page 179 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

class Example216 {
    public static void main(String[] args) throws IOException {
        numberConstants();
        System.out.println(getFunction("log2").get().applyAsDouble(32.0));
        System.out.println(getFunction("ln").get().applyAsDouble(32.0));
        System.out.println(getFunction("log").get().applyAsDouble(32.0));
        System.out.println(getFunction("log10").get().applyAsDouble(32.0));
        System.out.println(getFunction("sqrt").get().applyAsDouble(32.0));
        // System.out.println(getFunction("exp").get().applyAsDouble(32.0));
        getPageExample();
        diamondExample();
    }

    static Optional<DoubleUnaryOperator> getFunction(String name) {
        switch (name) {
            case "ln":
            case "log":
                return Optional.of(Math::log);
            case "log2":
                return Optional.of(x -> Math.log(x) / Math.log(2));
            case "log10":
                return Optional.of(Math::log10);
            case "sqrt":
                return Optional.of(Math::sqrt);
            default:
                return Optional.empty();
        }
    }

    static void diamondExample() {
        List<String> alist1 = new ArrayList<String>();    // Type argument <String> given
        List<String> alist2 = new ArrayList<>();          // Type argument <String> inferred
        // List<String> alist3 = new ArrayList();         // Raw type, unchecked conversion
        List<Function<String, List<Integer>>> flist = new ArrayList<>();
    }

    static void getPageExample() throws IOException {
        String url = "http://www.wikipedia.org/";
        String page = getPageAsString(url, 10);
        System.out.printf("%-30s%n%s%n", url, page);
        // This fails with an exception because the BufferedReader is closed too soon:
        // getPageAsStream(url).forEach(System.out::println);
    }

    public static String getPageAsString(String url, int maxLines) throws IOException {
        try (BufferedReader in
                     = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            Stream<String> lines = in.lines().limit(maxLines);
            return lines.collect(Collectors.joining());
        }
    }

    // This does NOT work -- the BufferedReader gets closed before the stream is used!
    // It compiles fine but fails at run-time with
    // java.io.UncheckedIOException: java.io.IOException: Stream closed
    // ... Caused by: java.io.IOException: Stream closed

    public static Stream<String> getPageAsStream(String url) throws IOException {
        try (BufferedReader in
                     = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            return in.lines();
        }
    }

    static void numberConstants() {
        int i1 = 0b1100_1010_1111_1110;             // Binary
        int i2 = 0xCAFE;                            // Hexadecimal
        int i3 = 0b1_100_101_011_111_110;           // Binary
        int i4 = 0145376;                           // Octal
        int i5 = 51966;                             // Decimal
        int i6 = -2_147_483_648;                    // Decimal
        int i7 = +2_147_483_647;                    // Decimal
        int i8 = 0x8000_0000;                       // Hexadecimal
        int i9 = 0x7FFF_FFFF;                       // Hexadecimal

        short s1 = 2_117;
        long l1 = 2_117L;
        long l2 = 0x7FFF_FFFF_FFFF_FFFFL;

        // National debt clock 2 May 2015, in USD:
        double debt = 18_210_520_570_642.0;         // Floating-point

        Number[] numbers = {i1, i2, i3, i4, i5, i6, i7, i8, i9, s1, l1, l2, debt};
        Arrays.stream(numbers).forEach(System.out::println);

        char c1 = 0b00110001; // '1'
        char c2 = 0b01000001; // 'A'
        System.out.println(c1);
        System.out.println(c2);
    }
}

