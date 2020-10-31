// Example 131 from page 101 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)


class ErasedHold {
    private Object contents;

    public void set(Object x) {
        contents = x;                       // Note: no cast
    }

    public Object get() {
        return contents;
    }
}

class Example131 {
    public static void main(String[] args) {
        ErasedHold h = new ErasedHold();
        h.set("foo");                       // Succeeds at run-time
        System.out.println("Succesfully executed  h.set(\"foo\")");
        h.get();                            // Succeeds at run-time
        System.out.println("Succesfully executed  h.get()");
        // String s = h.get();              // Illegal, rejected by compiler
        Integer i = (Integer) h.get();       // Legal, but fails at run-time
        System.out.println("Succesfully executed  Integer i = h.get()");
    }
}

