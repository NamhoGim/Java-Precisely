// Example 135 from page 107 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.*;

// The method unique takes a collection of file names and returns the
// list without duplicates, but retaining the order of the given ones.

class Example135 {
    public static void main(String[] args) {
        String[] filenames =
                {"Lib.java", "Foo.java", "Bar.java", "Lib.java", "Foo.java", "Goo.java"};
        for (String filename : unique(filenames))
            System.out.println(filename);
    }

    public static String[] unique(String[] filenames) {
        LinkedHashSet<String> uniqueFiles = new LinkedHashSet<String>();
        for (String filename : filenames)
            uniqueFiles.add(filename);
        return uniqueFiles.toArray(new String[0]);
    }
}
