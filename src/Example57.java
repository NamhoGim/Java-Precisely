// Example 57 from page 43 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point(com.precisely.java.example027.Point p) {
        this(p.x, p.y);
    }    // calls the above constructor

    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
