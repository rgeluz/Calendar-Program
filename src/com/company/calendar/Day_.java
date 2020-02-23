package com.company.calendar;



import com.company.Event;

import java.util.ArrayList;
import java.util.List;

public class Day_ extends Period_{

    //static
    private static int numOfObjects;

    //private
    private String dayId;
    private int year;
    private MonthEnum monthOfYear;
    private int weekNumber;
    private int dayNumber;
    private int dayOfWeekNumber;
    private DayOfWeekEnum dayOfWeek;
    private List<Event> eventList; //list of event objects

    //constructor
    public Day_(String weekId,
                int year,
                MonthEnum monthOfYear,
                int weekNumber,
                int dayNumber,
                int dayOfWeekNumber,
                DayOfWeekEnum dayOfWeek) {

        //create dayId
        int newID = numOfObjects +1;
        String dayId = weekId + newID;

        this.dayId = dayId;
        this.year = year;
        this.monthOfYear = monthOfYear;
        this.weekNumber = weekNumber;
        this.dayNumber = dayNumber;
        this.dayOfWeekNumber = dayOfWeekNumber;
        this.dayOfWeek = dayOfWeek;
        this.eventList = new ArrayList<Event>();

        //update object counter
        numOfObjects++;
    }

    //getters and setters


    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MonthEnum getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(MonthEnum monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayOfWeekNumber() {
        return dayOfWeekNumber;
    }

    public void setDayOfWeekNumber(int dayOfWeekNumber) {
        this.dayOfWeekNumber = dayOfWeekNumber;
    }

    public DayOfWeekEnum getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeekEnum dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    //methods

    @Override
    public void displayView() {
        displayDayView();
    }


    /*
        //TODO
     */
    private void displayDayView(){

    }

    /*
        add event to day
     */
    public void addEvent(Event newevent){
        this.eventList.add(newevent);
    }

    /*
        retrieve event list
     */
    public List<Event> getEventList() {

        return eventList;
    }
}
