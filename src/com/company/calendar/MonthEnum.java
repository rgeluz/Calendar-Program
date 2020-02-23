package com.company.calendar;

/*
    see "Java enum with multiple value types"
    https://stackoverflow.com/questions/19600684/java-enum-with-multiple-value-types
 */

public enum MonthEnum {
    //enumeration
    January(1,31,5),
    February(2,28,4),
    March(3,31,5),
    April(4, 30,5),
    May(5,31,6),
    June(6,30,5),
    July(7,31,5),
    August(8,31,6),
    September(9,30,5),
    October(10,31,5),
    November(11,30,5),
    December(12,31,5);

    //private
    private final int monthNumber;
    private final int numberOfDays;
    private final int numberOfWeeks;

    //constructor
    MonthEnum(int monthNumber, int numberOfDays, int numberOfWeeks) {
        this.monthNumber = monthNumber;
        this.numberOfDays = numberOfDays;
        this.numberOfWeeks = numberOfWeeks;
    }

    //methods
    public int getMonthNumber() { return monthNumber; }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }
}
