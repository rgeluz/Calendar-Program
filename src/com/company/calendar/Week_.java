package com.company.calendar;

import com.company.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Week_ extends Period_{

    //static
    private static int numOfObjects;

    //private
    private String weekId;
    private int year;
    private MonthEnum monthOfYear;
    private int weekNumber;
    private String weekName;
    private List<Day_> daysList;

    //constructor
    public Week_(
            String monthId,
            int year,
            MonthEnum monthOfYear,
            int weekNumber,
            List<Day_> daysList) {


        //create new weekId
        int newID = numOfObjects +1;
        String weekId = monthId + "_week: " + weekNumber + "_" + newID;


        this.weekId = weekId;
        this.year = year;
        this.monthOfYear = monthOfYear;
        this.weekNumber = weekNumber;
        this.daysList = daysList;


        //update object counter
        numOfObjects++;

    }

    //getters and setters
    public int getWeekNumber(){
        return weekNumber;
    }

    public List<Day_> getDaysList() {
        return daysList;
    }

    //methods


    private Day_ getDayInDaysList(String dayOfWeek){
        for(Day_ day_ : this.getDaysList()){
            if(day_.getDayOfWeek().name().equals(dayOfWeek)){
                return day_;
            }
        }
        return null;
    }

    @Override
    public void displayView() {
        displayWeekView();
    }


    private void displayWeekView(){
        
        System.out.println("WeekNumber: " + this.weekNumber);

        //get events for each day
        HashMap<String,String> listOfEventsPerDay = new HashMap<String,String>();


        for(DayOfWeekEnum dayOfWeekEnum : DayOfWeekEnum.values() ){ //iterate through each day of week.
            Day_ day_ = getDayInDaysList(dayOfWeekEnum.name());
            if(day_!=null){     //a day object exist for that day of the week.
                if(day_.getEventList()!=null){ //then check if there are events for that day object.
                    String listOfEvents = "";
                    for(Event event : day_.getEventList()){
                        listOfEvents += event.getEventTitle() + ", \n";
                    }
                    listOfEventsPerDay.put(day_.getDayOfWeek().name(), listOfEvents);
                } else { //otherwise, add empty string for that day of the week.
                    listOfEventsPerDay.put(day_.getDayOfWeek().name(), "");
                }
            } else {    //otherwise, add empty string for that day of the week.
                listOfEventsPerDay.put(dayOfWeekEnum.name(), "");
            }
        } //end of for

        //https://stackoverflow.com/questions/15215326/how-can-i-create-table-using-ascii-in-a-console
        /*String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| Column name     | ID   |%n");
        System.out.format("+-----------------+------+%n");
        for (int i = 0; i < 5; i++) {
            System.out.format(leftAlignFormat, "some data" + i, i * i);
        }
        System.out.format("+-----------------+------+%n");*/


        String sun = listOfEventsPerDay.get("SUNDAY");
        String mon = listOfEventsPerDay.get("MONDAY");
        String tue = listOfEventsPerDay.get("TUESDAY");
        String wed = listOfEventsPerDay.get("WEDNESDAY");
        String thur = listOfEventsPerDay.get("THURSDAY");
        String fri = listOfEventsPerDay.get("FRIDAY");
        String sat = listOfEventsPerDay.get("SATURDAY");

        String leftAlignFormat = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |%n";

        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("| Sunday          | Monday          | Tuesday         | Wednesday       | Thursday        | Friday          | Saturday        |%n");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format(leftAlignFormat, sun, mon, tue, wed, thur, fri, sat);
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");



    }




}
