// Example 73 from page 55 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

class Example73 {
    public static void main(String[] args) {
        System.out.println("44 is " + findCountry(44));
    }

    static String findCountry(int prefix) {
        switch (prefix) {
            case 1:
                return "North America";
            case 44:
                return "Great Britain";
            case 45:
                return "Denmark";
            case 299:
                return "Greenland";
            case 46:
                return "Sweden";
            case 7:
                return "Russia";
            case 972:
                return "Israel";
            default:
                return "Unknown";
        }
    }
}
