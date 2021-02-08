package com.precisely.java.example097;

public enum Month {
    JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30),
    JUL(31), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);

    private final int days;

    Month(int days) {
        this.days = days;
    }

    private final static Month[] month = values();    // Cache the array

    public int days(int year) {
        return this == FEB && MyDate.leapYear(year) ? 29 : days;
    }

    public static Month toMonth(int n) {
        return month[n - 1];
    }

    public int toInt() {
        return ordinal() + 1;
    }

    public Month succ() {
        return toMonth(toInt() + 1);
    }
}
