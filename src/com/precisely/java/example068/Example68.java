package com.precisely.java.example068;// Example 68 from page 51 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

class Example68 {
    public static void main(String[] args) {
        methodReferenceExamples();
        targetedTypeExamples();
    }

    private static void methodReferenceExamples() {
        // Form t::m reference to instance method
        BiFunction<String, Integer, Character> charat = String::charAt;
        // Form t::m reference to static method
        Function<String, Integer> parseint = Integer::parseInt;
        // Form e::m reference to instance method, receiver is the string
        Function<Integer, Character> hex1 = "0123456789ABCDEF"::charAt;
        Function<Integer, Character> hex2 = makeConverter(false);
        System.out.println(charat.apply("ABCDEF", 1));
        System.out.println(hex1.apply(13));
        System.out.println(hex2.apply(13));
        Function<Integer, C> makeC = C::new;
        C x = makeC.apply(10);
        System.out.println(x.getBVal().get());
        System.out.println(x.getCVal().get());
        Function<Integer, Double[]> make1DArray = Double[]::new;
        Consumer<String> print = System.out::println;
        Function<Integer, ArrayList<Double>> mkDoubleList = ArrayList::new;
        BiConsumer<Double[], Comparator<Double>> sorter = Arrays::sort;
        ArrayList<Double> list = mkDoubleList.apply(10);
        list.add(34.5);
        list.add(67.2);
        list.add(12.9);
        Double[] a = make1DArray.apply(list.size());
        list.toArray(a);
        sorter.accept(a, Comparator.naturalOrder());
        print.accept(Double.toString(a[0]));
    }

    private static Function<Integer, Character> makeConverter(boolean uppercase) {
        // Form e::m reference to instance method, computing the receiver
        return (uppercase ? "0123456789ABCDEF" : "0123456789abcdef")::charAt;
    }

    static class B {
        protected int val;

        public int getVal() {
            return val;
        }
    }

    static class C extends B {
        public C(int val) {
            this.val = val;
        }

        public Supplier<Integer> getBVal() {
            return super::getVal;
        }

        public Supplier<Integer> getCVal() {
            return this::getVal;
        }

        public int getVal() {
            return 117 * val;
        }
    }

    // A method M that returns a (non-void) value can match a method
    // reference expression with a targeted function type, such as a
    // Consumer, that does not return anything, as shown by ignore2.
    // The matching of a lambda expressions to its target type is not so
    // flexible.
    private static void typeInference() {
        Consumer<String> ignore0 = s -> {
        };
        Consumer<String> ignore2 = String::length;          // Legal, ignores return value
    }

    private static void targetedTypeExamples() {
        // int len0 = Double::toHexString.andThen(String::length).apply(123.5); // Illegal
        Function<Double, String> hexFun;
        hexFun = Double::toHexString;                            // Legal: Assignment right-hand side
        int len1 = hexFun.andThen(String::length).apply(123.5);
        int len2 = applyAndMeasure(Double::toHexString, 123.5);  // Legal: Argument position
        int len3 = ((Function<Double, String>) Double::toHexString).andThen(String::length).apply(123.5); // Legal: cast
        int len4 = makeToHex().andThen(String::length).apply(123.5);
        System.out.println(len1);
        System.out.println(len2);
        System.out.println(len3);
        System.out.println(len4);
    }

    static int applyAndMeasure(Function<Double, String> hexFun, double d) {
        return hexFun.andThen(String::length).apply(d);
    }

    static Function<Double, String> makeToHex() {
        return Double::toHexString;                            // Legal: In return context
    }
}

