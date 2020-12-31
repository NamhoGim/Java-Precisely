// Example 38 from page 29 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example38 {
    public static void main(String[] args) {
        System.out.println(max(69, 42));                       // max(int,int)
        System.out.println(max(2, 5, 7, 11, 3));               // max(int,int[])
        System.out.println(max(2, 5, 7, 11, 3)); // max(int,int[])
    }

    static int max(int x, int y) {
        return x > y ? x : y;
    }

    static int max(int x1, int... xr) {
        int res = x1;
        for (int x : xr)
            res = max(res, x);
        return res;
    }
}
