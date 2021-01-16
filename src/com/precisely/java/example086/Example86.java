package com.precisely.java.example086;
// Example 86 from page 61 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example86 {
    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("Usage: java Example86 <string>\n");
        else {
            String q = args[0];
            System.out.println(q + " substring of hjsdfk: " + substring1(q, "hjsdfk"));
        }
    }

    // Decide whether query is a substring of target (using continue)
    static boolean substring1(String query, String target) {
        nextposition:
        for (int j = 0; j <= target.length() - query.length(); j++) {
            for (int k = 0; k < query.length(); k++)
                if (target.charAt(j + k) != query.charAt(k))
                    continue nextposition;
            return true;
        }
        return false;
    }
}
