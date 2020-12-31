// Example 111 from page 85 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Buffer {
    private int contents;
    private boolean empty = true;

    public int get() {
        synchronized (this) {
            while (empty)
                try {
                    this.wait();
                } catch (InterruptedException x) {
                }
            empty = true;
            this.notifyAll();
            return contents;
        }
    }

    public void put(int v) {
        synchronized (this) {
            while (!empty)
                try {
                    this.wait();
                } catch (InterruptedException x) {
                }
            empty = false;
            contents = v;
            this.notifyAll();
        }
    }
}

class Example111 {
    public static void main(String[] args) {
        final Buffer buf = new Buffer();

        class Producer extends Thread {
            @Override
            public void run() {
                for (int i = 1; true; i++) {
                    buf.put(i);
                    Util.pause(10, 100);
                }
            }
        }

        class Consumer extends Thread {
            @Override
            public void run() {
                for (; ; )
                    System.out.println("Consumed " + buf.get());

            }
        }

        new Producer().start();
        new Consumer().start();
        new Consumer().start();
    }
}

