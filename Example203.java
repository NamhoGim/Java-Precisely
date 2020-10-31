// Example 203 from page 169 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.io.*;

class Example203 {
    public static void main(String[] args) throws IOException {
        if (args.length > 0)
            showDir(0, new File(args[0]));
        else
            showDir(0, new File(".."));
    }

    static void showDir(int indent, File file) throws IOException {
        for (int i = 0; i < indent; i++)
            System.out.print('-');
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++)
                showDir(indent + 4, files[i]);
        }
    }
}

