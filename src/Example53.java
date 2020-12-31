// Example 53 from page 41 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example53 {
    public static void main(String[] args) {
        double[] a = {365.0, 24.0, 60.0, 60.0};
        System.out.println(multiply(a));
    }

    static double multiply(double[] xs) {
        double prod = 1.0;
        for (int i = 0; i < xs.length; i++)
            prod *= xs[i];                    // Equivalent to: prod = prod * xs[i]
        return prod;
    }
}
