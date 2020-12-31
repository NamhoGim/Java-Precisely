// Example 75 from page 55 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example75 {
    public static void main(String[] args) {
        if (args.length != 2)
            System.out.println("Usage: Example75 <weekday> <hours>\n");
        else {
            double hours = Double.parseDouble(args[1]);
            switch (args[0]) {
                case "Monday":
                    System.out.format("Monday: pay is %.2f%n", 10 + 7.42 * hours);
                    break;
                case "Tuesday":
                case "Wednesday":
                case "Thursday":
                case "Friday":
                    System.out.format("Workday: pay is %.2f%n", 7.42 * hours);
                    break;
                case "Saturday":
                case "Sunday":
                    System.out.format("Weekend: pay is %.2f%n", 20 + 1.25 * 7.42 * hours);
                    break;
                default:
                    System.out.format("Unknown weekday: %s%n", args[0]);
            }
        }
    }
}
