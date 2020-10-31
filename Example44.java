// Example 44 from page 33 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.Iterator;

class Example44 {
    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("Usage: java Example44 <string>\n");
        else {
            Iterator<String> seq = suffixes(args[0]);
            while (seq.hasNext())
                System.out.println(seq.next());
        }
    }

    // Create and return an iterator over all non-empty suffixes of s
    static Iterator<String> suffixes(final String s) {
        return
                new Iterator<String>() {
                    int startindex = 0;

                    public boolean hasNext() {
                        return startindex < s.length();
                    }

                    public String next() {
                        return s.substring(startindex++);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
    }
}

