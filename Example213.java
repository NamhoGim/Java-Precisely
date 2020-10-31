// Example 213 from page 177 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.function.Consumer;

class Example213 {
    public static void main(String[] args) {
        Consumer<Integer>[] consumers = Example213.makeConsumerArray(32);
        callAll(5, consumers);
        callAll(5, i -> {
        }, i -> {
        });
    }

    @SafeVarargs
    public static final <T> void callAll(T x, Consumer<T>... consumers) {
        for (Consumer<T> cons : consumers)
            if (cons != null)
                cons.accept(x);
    }

    @SuppressWarnings("unchecked")
    private static <T> Consumer<T>[] makeConsumerArray(int size) {
        return (Consumer<T>[]) new Consumer[size];
    }

    static class B {
        public void m1() {
        }
    }

    interface I {
        void m2();
    }

    static class C extends B implements I {
        @Override
        public void m1() {
            System.out.println("m1");
        }

        @Override
        public void m2() {
            System.out.println("m2");
        }

        // @Override // Would cause compiler error because no method m3() to override
        public void m3() {
            System.out.println("m3");
        }
    }

    @FunctionalInterface
    interface CharPredicate {
        boolean test(char c);

        default CharPredicate and(CharPredicate p) {
            return c -> this.test(c) && p.test(c);
        }
    }
}


