package com.precisely.java.example010;
// Example 10 from page 11 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)


class Example10 {
    public static void main(String[] args) {
        System.out.println(ecount(""));
        System.out.println(ecount("hjsdafj yew eqwh ge Ee"));
        System.out.println(ecount("hjsdafj yew fqwh gf Ef"));
    }

    static int ecount(String s) {
        int ecount = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == 'e')
                ecount++;
        return ecount;
    }
}

