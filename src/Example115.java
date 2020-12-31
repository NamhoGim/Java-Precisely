// Example 115 from page 87 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example115 {
    public static void main(String[] args) {
        final int size = 100_000, tests = 10_000;
        IntArray ia = new IntArray(size);
        IntArrayVolatile iav = new IntArrayVolatile(size);
        {
            System.out.println("Field array not volatile:");
            Timer t = new Timer();
            for (int i = 0; i < tests; i++)
                if (!ia.isSorted())
                    System.out.println("Unexpected!");
            System.out.printf("%10.1f us/call%n", t.check() * 1E6 / tests);
        }
        {
            System.out.println("Field array volatile:");
            Timer t = new Timer();
            for (int i = 0; i < tests; i++)
                if (!iav.isSorted())
                    System.out.println("Unexpected!");
            System.out.printf("%10.1f us/call%n", t.check() * 1E6 / tests);
        }
    }

    // Simple timer, measuring wall-clock (elapsed) time in seconds
    private final static class Timer {
        private final long start;

        public Timer() {
            start = System.nanoTime();
        }

        public double check() {
            return (System.nanoTime() - start) / 1e9;
        }
    }
}

class IntArray {
    private final int[] array;

    public IntArray(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = 2 * i + 1;
    }

    public boolean isSorted() {
        for (int i = 1; i < array.length; i++)
            if (array[i - 1] > array[i])
                return false;
        return true;
    }
}

class IntArrayVolatile {
    private final int[] array;

    public IntArrayVolatile(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = 2 * i + 1;

    }

    public boolean isSorted() {
        for (int i = 1; i < array.length; i++)
            if (array[i - 1] > array[i])
                return false;
        return true;
    }
}

