// Example 52 from page 41 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example52 {
    public static void main(String[] args) {
        com.precisely.java.example027.Point p1 = new com.precisely.java.example027.Point(10, 20);
        System.out.println("p1 is " + p1);        // Prints: p1 is (10, 20)
        com.precisely.java.example027.Point p2 = p1;                            // p1 and p2 are same object
        p2.move(8, 8);
        System.out.println("p2 is " + p2);        // Prints: p2 is (18, 28)
        System.out.println("p1 is " + p1);        // Prints: p1 is (18, 28)
    }
}
