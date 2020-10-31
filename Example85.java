// Example 85 from page 61 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)


class Example85 {
    public static void main(String[] args) {
        double[] a = {365.0, 24.0, 60.0, 60.0};
        System.out.println(shortcutmultiply(a));
    }

    static double shortcutmultiply(double[] xs) {
        double prod = 1.0;
        for (int i = 0; i < xs.length; i++) {
            prod *= xs[i];
            if (prod == 0.0)
                break;
        }
        return prod;
    }
}

