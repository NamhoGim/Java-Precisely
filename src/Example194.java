// Example 194 from page 157 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.io.*;

class Example194 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1)
            System.out.println("Usage: java Example194 <filename>");
        else
            sumfile(args[0]);
    }

    static void sumfile(String filename) throws IOException {
        Reader r = new BufferedReader(new FileReader(filename));
        StreamTokenizer stok = new StreamTokenizer(r);
        double sum = 0;
        stok.nextToken();
        while (stok.ttype != StreamTokenizer.TT_EOF) {
            if (stok.ttype == StreamTokenizer.TT_NUMBER)
                sum += stok.nval;
            else
                System.out.println("Non-number: " + stok.sval);
            stok.nextToken();
        }
        System.out.println("The file sum is " + sum);
    }
}
