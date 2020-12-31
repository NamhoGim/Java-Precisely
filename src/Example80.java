// Example 80 from page 59 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example80 {
    public static void main(String[] args) {
        System.out.println("Thursday is " + wdayno2("Thursday"));
    }

    static int wdayno2(String wday) {
        int i = 0;
        while (i < wdays.length && !wday.equals(wdays[i]))
            i++;
        // Now i >= wdays.length or wday equal to wdays[i]
        if (i < wdays.length)
            return i + 1;
        else
            return -1;                                // Here used to mean `not found'
    }

    static final String[] wdays =
            {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
}
