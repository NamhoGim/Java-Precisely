// Example 180 from page 141 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

class Example180 {
    public static void main(String[] args) {
        simpleStatistics();
        betterStatistics();
        //    uselesslyConsumedTwice();
    }

    private static void simpleStatistics() {
        DoubleStream ds = DoubleStream.of(2, 4, 4, 4, 5, 5, 7, 9);
        DoubleSummaryStatistics stats = ds.summaryStatistics();
        // DoubleSummaryStatistics stats
        //   = ds.collect(DoubleSummaryStatistics::new,
        //                DoubleSummaryStatistics::accept,
        //                DoubleSummaryStatistics::combine);
        System.out.printf("count=%d, min=%g, max=%g, sum=%g, mean=%g%n",
                stats.getCount(), stats.getMin(), stats.getMax(),
                stats.getSum(), stats.getAverage());
    }

    // How to extend DoubleSummaryStatistics to also compute standard
    // deviation.  Since a stream cannot be consumed twice, we do it in
    // one pass by subclassing instead of, say, computing the mean in a
    // first pass and then computing the standard deviation in the
    // second pass, although that would be numerically better.
    private static void betterStatistics() {
        DoubleStream ds = DoubleStream.of(2, 4, 4, 4, 5, 5, 7, 9);
        BetterDoubleStatistics stats
                = ds.collect(BetterDoubleStatistics::new,
                BetterDoubleStatistics::accept,
                BetterDoubleStatistics::combine);
        System.out.printf("count=%d, min=%g, max=%g, sum=%g, mean=%g, sdev=%g%n",
                stats.getCount(), stats.getMin(), stats.getMax(),
                stats.getSum(), stats.getAverage(), stats.getSdev());
    }

    private static void uselesslyConsumedTwice() {
        DoubleStream ds = DoubleStream.of(2, 4, 4, 4, 5, 5, 7, 9);
        DoubleSummaryStatistics stats = ds.summaryStatistics();
        // This throws IllegalStateException: stream has already been operated upon or closed:
        double sqsum = ds.map(x -> x * x).sum();
        double sdev = Math.sqrt(sqsum / stats.getCount() - stats.getAverage() * stats.getAverage());
    }
}

class BetterDoubleStatistics extends DoubleSummaryStatistics {
    private double sqsum = 0.0;

    @Override
    public void accept(double d) {
        super.accept(d);
        sqsum += d * d;
    }

    public void combine(BetterDoubleStatistics other) {
        super.combine(other);
        sqsum += other.sqsum;
    }

    public double getSdev() {
        double mean = getAverage();
        return Math.sqrt(sqsum / getCount() - mean * mean);
    }
}

