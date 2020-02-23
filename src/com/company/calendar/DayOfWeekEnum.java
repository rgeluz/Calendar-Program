package com.company.calendar;

public enum DayOfWeekEnum {
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6);


    //private
    private final int dayNumber;

    //constructor

    DayOfWeekEnum(int dayNumber) {
        this.dayNumber = dayNumber;
    }


    //methods

    public int getDayNumber() {
        return dayNumber;
    }


}
