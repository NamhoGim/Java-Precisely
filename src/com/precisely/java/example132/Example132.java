package com.precisely.java.example132;
// Example 132 from page 101 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.*;

class G<T> {
}

class Example132 {
    public static void main(String[] args) {
        new F<Double>().M();
    }
}

class F<T> {
    public void M() {
        T[] tarr;                              // Legal declaration
        G<T>[] ctarr;                          // Legal declaration
        G<Integer>[] ciarr;                    // Legal declaration

        // tarr = new T[5];                    // Illegal generic array creation
        // ctarr = new G<T>[5];                // Illegal generic array creation
        // ciarr = new G<Integer>[5];          // Illegal generic array creation

        ArrayList<T> tlist;                    // Legal declaration
        ArrayList<G<T>> ctlist;                // Legal declaration
        ArrayList<G<Integer>> cilist;          // Legal declaration

        tlist = new ArrayList<T>();            // Legal array list creation
        ctlist = new ArrayList<G<T>>();        // Legal array list creation
        cilist = new ArrayList<G<Integer>>();  // Legal array list creation
    }
}
