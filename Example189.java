// Example 189 from page 149 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.io.*;

class Example189 {
    public static void main(String[] args) throws IOException {
        System.out.println("Type some lines of text, end with an empty line:");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        String s = r.readLine();
        while (s != null && !s.equals("")) {
            count++;
            s = r.readLine();
        }
        System.out.println("You entered " + count + " non-empty lines");
    }
}

