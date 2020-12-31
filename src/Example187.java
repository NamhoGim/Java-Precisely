// Example 187 from page 147 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class Example187 {
    public static void main(String[] args) {
        Map<String, String> form = new HashMap<String, String>();
        form.put("area", "144.0");
        doubleExampleA(form);
        doubleExampleB(form);
        doubleExampleC(form);
    }

    public static void doubleExampleA(Map<String, String> form) {
        String areaString = form.get("area"), toPrint = "No value";
        if (areaString != null) {
            try {
                double areaValue = Double.parseDouble(areaString);
                double result = Math.sqrt(areaValue);
                if (!Double.isNaN(result))
                    toPrint = String.valueOf(result);
            } catch (NumberFormatException exn) {
            }
        }
        System.out.println(toPrint);
    }

    public static void doubleExampleB(Map<String, String> form) {
        Optional<String> areaString = Optional.ofNullable(form.get("area"));
        Optional<Double> areaValue = areaString.flatMap(s -> parseDouble(s));
        Optional<Double> result = areaValue.flatMap(v -> sqrt(v));
        System.out.println(result.map(String::valueOf).orElse("No value"));
    }

    public static void doubleExampleC(Map<String, String> form) {
        String toPrint = Optional.ofNullable(form.get("area"))
                .flatMap(s -> parseDouble(s))
                .flatMap(v -> sqrt(v))
                .map(String::valueOf)
                .orElse("No value");
        System.out.println(toPrint);
    }

    public static Optional<Double> parseDouble(String s) {
        try {
            return Optional.of(Double.parseDouble(s));
        } catch (NumberFormatException exn) {
            return Optional.empty();
        }
    }

    public static Optional<Double> sqrt(double x) {
        return x < 0.0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}

