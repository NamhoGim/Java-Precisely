// Example 161 from page 131 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

class Example161 {
    public static void main(String[] args) {
        compileTimeLegalAndIllegal();
        defineFunction();
        defineToIntFunction();
        defineVarargFunction();
    }

    private static void defineVarargFunction() {
        // Three equivalent ways of defining a lambda with variable number of arguments
        VarargFunction<String, String>
                fsas1 = ss -> String.join(":", ss),
                fsas2 = (String[] ss) -> String.join(":", ss),
                fsas3 = (String... ss) -> String.join(":", ss);
        System.out.println(fsas1.apply("abc", "DEF"));
        System.out.println(fsas2.apply("abc", "DEF"));
        System.out.println(fsas3.apply("abc", "DEF"));
        // A derived interface has also the superinterface's default
        // methods but its static methods:
        System.out.println(fsas3.andThen(String::length).apply(new String[]{"abc", "DEF"}));
    }

    private static void defineFunction() {
        Function<String, Integer>
                fsi1 = s -> Integer.parseInt(s),             // lambda with parameter s
                fsi2 = (String s) -> Integer.parseInt(s),    // same, with explicit parameter type
                fsi3 = Integer::parseInt,                    // reference to static method Integer.parseInt
                fsi4 = Integer::new,                         // reference to constructor Integer(String)
                fsi5 = s -> s.length(),                      // lambda with parameter s
                fsi6 = String::length,                       // reference to instance method s.length()
                fsi7 = new Function<String, Integer>() {      // anonymous inner class (Java 1.1)
                    public Integer apply(String s) {
                        return s.length();
                    }
                };
        applyFsi(fsi1);
        Stream<Function<String, Integer>> fsis = Stream.of(fsi1, fsi2, fsi3, fsi4, fsi5, fsi6, fsi7);
        fsis.map(fsi -> fsi.apply("4711")).forEach(System.out::println);
    }

    private static void applyFsi(Function<String, Integer> fsi) {
        int res = fsi.apply("4711");
        System.out.println(res);
    }

    private static void defineToIntFunction() {
        ToIntFunction<String>
                fsi1 = s -> Integer.parseInt(s),             // lambda with parameter s
                fsi2 = (String s) -> Integer.parseInt(s),    // same, with explicit parameter type
                fsi3 = Integer::parseInt,                    // reference to static method Integer.parseInt
                fsi4 = Integer::new,                         // reference to constructor Integer(String)
                fsi5 = s -> s.length(),                      // lambda with parameter s
                fsi6 = String::length,                       // reference to instance method s.length()
                fsi7 = new ToIntFunction<String>() {         // anonymous inner class (Java 1.1)
                    public int applyAsInt(String s) {
                        return s.length();
                    }
                };
        applyFsi(fsi1);
        Stream<ToIntFunction<String>> fsis = Stream.of(fsi1, fsi2, fsi3, fsi4, fsi5, fsi6, fsi7);
        fsis.map(fsi -> fsi.applyAsInt("4711")).forEach(System.out::println);

        Function<String, Integer> f = s -> Integer.parseInt(s);
        // Type error: Function<String,Integer> cannot be converted to ToIntFunction<String>
        // ToIntFunction<String> g = f;
    }

    private static void applyFsi(ToIntFunction<String> fsi) {
        int res = fsi.applyAsInt("4711");
        System.out.println(res);
    }

    private static void compileTimeLegalAndIllegal() {
        // Illegal: Double::toString is not in assignment, argument or casting context
        // Function<Double,Integer> fdi1 = Double::toHexString.andThen(String::length);
        // Legal: Double::toString is in casting context
        Function<Double, Integer> fdi2
                = ((Function<Double, String>) Double::toHexString).andThen(String::length);
        System.out.println(fdi2.apply(1.1));
        // Illegal: No andThen method on DoubleFunction<String>
        // Function<Double,Integer> fdi3 = ((DoubleFunction<String>)Double::toHexString).andThen(String::length);
    }

    @FunctionalInterface
    @SuppressWarnings("unchecked")
    interface VarargFunction<T, R> extends Function<T[], R> {
        R apply(T... xs);
    }
}

