// Example 199 from page 165 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.io.*;

// Simple timer, measuring wall-clock (elapsed) time in seconds
class Timer {
    private final long start;

    public Timer() {
        start = System.nanoTime();
    }

    public double check() {
        return (System.nanoTime() - start) / 1e9;
    }
}

class Example199 {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            OutputStream os1 = new FileOutputStream("tmp1.dat");
            writeints("Unbuffered FileOutputStream: ", 1000000, os1);
            OutputStream os2 = new BufferedOutputStream(new FileOutputStream("tmp2.dat"));
            writeints("Buffered FileOutputStream:   ", 1000000, os2);
            Writer wr1 = new FileWriter("tmp1.dat");
            writeints("Unbuffered FileWriter: ", 1000000, wr1);
            Writer wr2 = new BufferedWriter(new FileWriter("tmp2.dat"));
            writeints("Buffered FileWriter:   ", 1000000, wr2);
        }
    }

    static void writeints(String msg, int count, OutputStream os)
            throws IOException {
        Timer t = new Timer();
        for (int i = 0; i < count; i++)
            os.write(i & 255);
        os.close();
        System.out.println(msg + t.check());
    }

    static void writeints(String msg, int count, Writer os)
            throws IOException {
        Timer t = new Timer();
        for (int i = 0; i < count; i++)
            os.write(i & 255);
        os.close();
        System.out.println(msg + t.check());
    }
}
