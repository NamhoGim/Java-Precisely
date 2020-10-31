// Example 90 from page 63 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.io.*;

class Example90 {
    public static void main(String[] args) throws IOException {
        {
            double[] xs = readRecord1("foo");
            for (int i = 0; i < xs.length; i++)
                System.out.println(xs[i]);
        }
        {
            double[] xs = readRecord2("foo");
            for (int i = 0; i < xs.length; i++)
                System.out.println(xs[i]);
        }
    }

    static double[] readRecord1(String filename) throws IOException {
        double[] res = new double[3];
        BufferedReader breader = new BufferedReader(new FileReader(filename));
        try {
            res[0] = Double.parseDouble(breader.readLine());
            res[1] = Double.parseDouble(breader.readLine());
            res[2] = Double.parseDouble(breader.readLine());
            return res;
        } finally {
            breader.close();
        }
    }

    static double[] readRecord2(String filename) throws IOException {
        double[] res = new double[3];
        try (BufferedReader breader = new BufferedReader(new FileReader(filename))) {
            res[0] = Double.parseDouble(breader.readLine());
            res[1] = Double.parseDouble(breader.readLine());
            res[2] = Double.parseDouble(breader.readLine());
            return res;
        }
    }
}

