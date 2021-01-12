package com.precisely.java.example064;
// Example 64 from page 49 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class Example64 {
    public static void main(String[] args) {
        simpleLambdas();
        higherOrderLambdas();
    }

    private static void simpleLambdas() {
        // Four equivalent ways to define the same function:
        Function<String, Integer>
                fsi1 = s -> Integer.parseInt(s),
                fsi2 = s -> {
                    return Integer.parseInt(s);
                },
                fsi3 = (String s) -> Integer.parseInt(s),
                fsi4 = (final String s) -> Integer.parseInt(s);
        // Three equivalent ways to define the same function, which
        // returns the at most 3-letter substring starting at i:
        BiFunction<String, Integer, String>
                fsis1 = (s, i) -> s.substring(i, Math.min(i + 3, s.length())),
                fsis2 = (s, i) -> {
                    int to = Math.min(i + 3, s.length());
                    return s.substring(i, to);
                },
                fsis3 = (String s, Integer i) -> s.substring(i, Math.min(i + 3, s.length()));
        BiFunction<String, String, String>
                concat = (s1, s2) -> s1 + s2;
        // Empty parameter list.
        // The Date object is creates when now.get() is called, not when it is defined:
        Supplier<String>
                now = () -> new java.util.Date().toString();
        // Two equivalent ways to define a lambda with return type void:
        Consumer<String>
                show1 = s -> System.out.println(">>>" + s + "<<<"),
                show2 = s -> {
                    System.out.println(">>>" + s + "<<<");
                };
        // Three equivalent ways to define a function from String[] to
        // String.  Declaring ss as a parameter array (variable arity) in
        // fsas3 does not mean that the function can be called with any
        // number of String arguments: the signature of apply in
        // Function<String[],String> remains String apply(String[]).
        Function<String[], String>
                fsas1 = ss -> String.join(":", ss),
                fsas2 = (String[] ss) -> String.join(":", ss),
                fsas3 = (String... ss) -> String.join(":", ss);
        // Calling the defined functions:
        System.out.println(fsi1.apply("004711"));
        System.out.println(fsi2.apply("004711"));
        System.out.println(fsi3.apply("004711"));
        System.out.println(fsi4.apply("004711"));
        System.out.println(fsis1.apply("abcdef", 4));
        System.out.println(fsis2.apply("abcdef", 4));
        System.out.println(fsis3.apply("abcdef", 4));
        System.out.println(now.get());
        show1.accept(now.get());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException exn) {
        }
        show2.accept(now.get());
        System.out.println(fsas1.apply(new String[]{"abc", "DEF"}));
        System.out.println(fsas2.apply(new String[]{"abc", "DEF"}));
        System.out.println(fsas3.apply(new String[]{"abc", "DEF"}));
        // fsas3.apply("abc", "DEF"); // Illegal: Must take one String[] argument
    }

    private static void higherOrderLambdas() {
        // A function that returns a function; this is a curried version of concat:
        Function<String, Function<String, String>>
                prefix = s1 -> s2 -> s1 + s2;
        Function<String, String>
                addDollar = prefix.apply("$");
        // A function that takes as argument a function:
        BiFunction<Function<String, String>, String, String>
                twice = (f, s) -> f.apply(f.apply(s));
        Function<String, String>
                addTwoDollars = s -> twice.apply(addDollar, s);
        // Calling the defined functions:
        System.out.println(prefix.apply("$").apply("100"));
        System.out.println(addDollar.apply("100"));
        System.out.println(twice.apply(prefix.apply("quack "), "said Donald"));
        System.out.println(addTwoDollars.apply("100"));
    }

    private static void lambdaExperiments() {
        // Curried lambdas
        // Cannot create an array of lambdas because not in assignment or
        // parameter context:
        // Function<String,Integer>[] a
        //   = new Function<String,Integer>[] { s -> s.length(), s -> 42, s -> Integer.parseInt(s) };
    }
}
