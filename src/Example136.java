// Example 136 from page 107 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.*;
import java.io.*;

class Example136 {
    public static void main(String[] args) {
        SortedSet<String> filenames = new TreeSet<String>();
        File cwd = new File(".");           // Current working directory
        for (File f : cwd.listFiles())
            filenames.add(f.getName());
        for (String filename : filenames.subSet("P", "T"))
            System.out.println(filename);
    }
}

