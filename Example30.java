// Example 30 from page 25 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)


abstract class Vessel {
    double contents;

    abstract double capacity();

    void fill(double amount) {
        contents = Math.min(contents + amount, capacity());
    }
}

class Tank extends Vessel {
    double length, width, height;

    Tank(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double capacity() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return "tank (" + length + ", " + width + ", " + height + ")";
    }
}

class Cube extends Tank {
    Cube(double side) {
        super(side, side, side);
    }

    @Override
    public String toString() {
        return "cube (" + length + ")";
    }
}

class Barrel extends Vessel {
    double radius, height;

    Barrel(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    double capacity() {
        return height * Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "barrel (" + radius + ", " + height + ")";
    }
}

