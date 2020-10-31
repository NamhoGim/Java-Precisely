// Example 148 from page 117 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

class Example148 {
    public static void main(String[] args) {
        addressSorting();
        stringSorting();
    }

    static void addressSorting() {
        Address[] addresses =
                new Address[]{new Address("Rose Road", 31, "75095"),
                        new Address("Rose Road", 17, "75095"),
                        new Address("Sycamore Drive", 11, "22430"),
                        new Address("Pine Street", 13, "02142")};
        Comparator<Address> cmpStreet = Comparator.comparing(addr -> addr.street);
        Comparator<Address> cmpStreetReverse = cmpStreet.reversed();
        Comparator<Address> cmpStreetThenNumber
                // The type arguments <Address,String> are needed here:
                = Comparator.<Address, String>comparing(addr -> addr.street)
                .thenComparingInt(addr -> addr.number);
        System.out.println("\nStream sort by street name:");
        Stream.of(addresses).sorted(cmpStreet).forEach(System.out::println);
        System.out.println("\n\nStream sort by street name, reversed:");
        Stream.of(addresses).sorted(cmpStreetReverse).forEach(System.out::println);
        System.out.println("\n\nStream sort by street name and house number:");
        Stream.of(addresses).sorted(cmpStreetThenNumber).forEach(System.out::println);
        System.out.println("\n\nArray sort by street name and house number:");
        Arrays.sort(addresses, cmpStreetThenNumber);
        Stream.of(addresses).forEach(System.out::println);
    }

    static void stringSorting() {
        String[] words = {"car", "ape", "act", "an", "ax", "bat", "axiom", "be", "word"};
        Comparator<String> shortestThenLetters
                = Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder());
        Comparator<String> longestThenLetters
                = Comparator.comparing(String::length)
                .reversed()
                .thenComparing(Comparator.naturalOrder());
        System.out.println("\n\nStream sort by natural letter order:");
        Stream.of(words).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println("\n\nStream sort by reverse natural letter order:");
        Stream.of(words).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println("\n\nStream sort by word length:");
        Stream.of(words).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        System.out.println("\n\nStream sort by increasing word length, then letters:");
        Stream.of(words).sorted(shortestThenLetters).forEach(System.out::println);
        System.out.println("\n\nStream sort by decreasing word length, then letters:");
        Stream.of(words).sorted(longestThenLetters).forEach(System.out::println);
    }
}

class Address {
    public final String street, postcode;
    public final int number;

    public Address(String street, int number, String postcode) {
        this.street = street;
        this.number = number;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return String.format("%s #%d in %s", street, number, postcode);
    }
}

