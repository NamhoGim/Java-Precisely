// Example 143 from page 113 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

class Example143 {
    public static void main(String[] args) {
        for (int i : fromTo(13, 17))
            System.out.println(i);
        for (int i : fromToStream(13, 17))
            System.out.println(i);
        List<IntUnaryOperator> functions = new ArrayList<>();
        for (int i : fromTo(13, 17))
            functions.add(j -> j * i);
        for (IntUnaryOperator f : functions)
            System.out.println(f.applyAsInt(10));
    }

    public static Iterable<Integer> fromTo(final int m, final int n) {
        class FromToIterator implements Iterator<Integer> {
            private int i = m;

            public boolean hasNext() {
                return i <= n;
            }

            public Integer next() {
                if (i <= n)
                    return i++;
                else
                    throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
        class FromToIterable implements Iterable<Integer> {
            public Iterator<Integer> iterator() {
                return new FromToIterator();
            }
        }
        return new FromToIterable();
    }

    public static Iterable<Integer> fromToStream(final int m, final int n) {
        return () -> IntStream.rangeClosed(m, n).iterator();
    }
}


