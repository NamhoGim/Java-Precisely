// Example 134 from page 107 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.*;

// The HashSet is 3 to 9 times faster than Arrays.binarySearch, even
// for this list of strings of only 52 elements:

class Example134 {
    final static String[] keywordarray =
            {"abstract", "assert", "boolean", "break", "byte", "case", "catch",
                    "char", "class", "const", "continue", "default", "do", "double", "else",
                    "enum", "extends", "false", "final", "finally", "float", "for", "goto",
                    "if", "implements", "import", "instanceof", "int", "interface", "long",
                    "native", "new", "null", "package", "private", "protected", "public",
                    "return", "short", "static", "strictfp", "super", "switch",
                    "synchronized", "this", "throw", "throws", "transient", "true",
                    "try", "void", "volatile", "while"};

    final static Set<String> keywords
            = new HashSet<String>(Arrays.asList(keywordarray));

    static boolean isKeyword1(String id) {
        return keywords.contains(id);
    }

    static boolean isKeyword2(String id) {
        return Arrays.binarySearch(keywordarray, id) >= 0;
    }

    public static void main(String[] args) {
        if (args.length != 2)
            System.out.println("Usage: java Example134 <iterations> <word>");
        else {
            final int count = Integer.parseInt(args[0]);
            final String id = args[1];
            for (int i = 0; i < keywordarray.length; i++)
                if (isKeyword1(keywordarray[i]) != isKeyword2(keywordarray[i]))
                    System.out.println("Error at i = " + i);
            if (isKeyword1(id) != isKeyword2(id))
                System.out.println("Error at id = " + id);

            System.out.print("HashSet.contains    ");
            Timer t1 = new Timer();
            for (int i = 0; i < count; i++)
                isKeyword1(id);
            System.out.println(t1.check());

            System.out.print("Arrays.binarySearch ");
            Timer t2 = new Timer();
            for (int i = 0; i < count; i++)
                isKeyword2(id);
            System.out.println(t2.check());
        }
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
}

