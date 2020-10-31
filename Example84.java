// Example 84 from page 61 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)


class Example84 {
    public static void main(String[] args) {
        System.out.println("Thursday is " + wdayno3("Thursday"));
    }

    static int wdayno3(String wday) {
        for (int i = 0; i < wdays.length; i++)
            if (wday.equals(wdays[i]))
                return i + 1;
        return -1;                                  // Here used to mean `not found'
    }

    static final String[] wdays =
            {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
}

