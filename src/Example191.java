// Example 191 from page 155 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.io.*;

class Example191 {
    public static void main(String[] args) throws IOException {
        System.out.println("Writing to file dice.txt");
        PrintWriter pw = new PrintWriter(new FileWriter("dice.txt"));
        for (int i = 1; i <= 1000; i++) {
            int die = (int) (1 + 6 * Math.random());
            pw.print(die);
            pw.print(' ');
            if (i % 20 == 0) pw.println();
        }
        pw.println();
        pw.close();                 // without this, the output file may be empty
    }
}
