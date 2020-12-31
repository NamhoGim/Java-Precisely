// Example 41 from page 31 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example41 {
    static double[] ps = new double[6];

    static {                              // static initializer block
        double sum = 0;
        for (int i = 0; i < ps.length; i++)     // fill with increasing random numbers
            ps[i] = sum += Math.random();
        for (int i = 0; i < ps.length; i++)     // scale so last ps element is 1.0
            ps[i] /= sum;
    }

    static int roll() {
        double p = Math.random();
        int i = 0;
        while (p > ps[i])
            i++;
        return i + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(roll());
    }
}
