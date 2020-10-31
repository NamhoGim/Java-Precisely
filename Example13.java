// Example 13 from page 13 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)


class Example13 {
    public static void main(String[] args) {
        String res = String.format("|%1$s|%1$7s|%1$-7s|", "Oslo");
        System.out.println(res);
    }
}

