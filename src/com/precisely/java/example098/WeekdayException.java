package com.precisely.java.example098;
// Example 98 from page 73 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

public class WeekdayException extends Exception {
    static final long serialVersionUID = 50L;

    public WeekdayException(String wday) {
        super("Illegal weekday: " + wday);
    }
}
