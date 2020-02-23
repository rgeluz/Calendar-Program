package com.company.calendar;

import com.company.Main;

import java.util.ArrayList;
import java.util.List;

public class Month_ extends Period_{

    //static
    private static int numOfObjects;


    //private
    private String monthId;
    private int year;
    private int monthNumber;
    private MonthEnum monthOfYear;
    private int numOfDays;
    private int numOfWeeks;
    private List<Week_> weeksList;

    //constructor
    public Month_(String yearId,
                  int year,
                  MonthEnum monthOfYear) {

        //create new monthId
        int newID = numOfObjects +1;
        String monthId = yearId + "_"+ monthOfYear.name() + "_" + newID;

        this.monthId = monthId;
        this.year = year;
        this.monthNumber = monthOfYear.getMonthNumber();
        this.monthOfYear = monthOfYear;
        this.numOfDays = monthOfYear.getNumberOfDays();
        this.numOfWeeks = monthOfYear.getNumberOfWeeks();
        this.weeksList = new ArrayList<Week_>();

        //update object counter
        numOfObjects++;

        //add weeks to the weeks list
        createWeeksList();
    }

    //getter and setters

    public String getMonthId() {
        return monthId;
    }

    public void setMonthId(String monthId) {
        this.monthId = monthId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public MonthEnum getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(MonthEnum monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

    public int getNumOfWeeks() {
        return numOfWeeks;
    }

    public void setNumOfWeeks(int numOfWeeks) {
        this.numOfWeeks = numOfWeeks;
    }

    public List<Week_> getWeeksList() {
        return weeksList;
    }

    public void setWeeksList(List<Week_> weeksList) {
        this.weeksList = weeksList;
    }


    //methods

    /*
        add all the weeks to the month
        also add all of the days in the week before adding to the month
            decided to move that logic here
     */
    private void createWeeksList(){
        int dayCounter = 1; //start at the first day

        for(int i = 0; i < this.numOfWeeks; i++){
            int weekNumber = i + 1;
            String weekName = monthOfYear.name() + "_week: " + weekNumber;

            //create new dayList per week
            List<Day_> daysList = new ArrayList<Day_>();
            //todo

            //iterate through days of the week to build dayslist:
            //0 for Sunday, 1 for Monday, and so forth.
            for(int d =0; d<7; d++) {
                int dayOfWeekNumber = dayOfWeek(monthNumber, dayCounter, year);
                DayOfWeekEnum dayOfWeekEnum = null;
                for(DayOfWeekEnum dayOfWeek : DayOfWeekEnum.values()){
                    if(dayOfWeek.getDayNumber()==dayOfWeekNumber){
                        dayOfWeekEnum = dayOfWeek;
                        break;
                    }
                }

                //add all the days of the month
                /*if(dayCounter<=this.numOfDays) {

                }*/

                if(d==dayOfWeekNumber){
                    Day_ newDay = new Day_(
                            this.monthId,
                            this.year,
                            this.monthOfYear,
                            weekNumber,
                            dayCounter,
                            dayOfWeekNumber,
                            dayOfWeekEnum
                    );
                    dayCounter++;
                    daysList.add(newDay);
                }
            } //end of for, for day list


            Week_ newWeek = new Week_(
                    this.monthId,
                    this.year,
                    this.monthOfYear,
                    weekNumber,
                    daysList);
            weeksList.add(newWeek);
        } //end of for, for week list
    }

    @Override
    public void displayView() {
        displayMonthView();
    }

    private void displayMonthView(){

        //https://introcs.cs.princeton.edu/java/21function/Calendar.java.html
        // print monthly the calendar
        //StdOut.println("   " + months[month] + " " + year);
        //StdOut.println(" S  M Tu  W Th  F  S");
        Main.p("   " + this.monthOfYear.name() + " " + this.year);
        Main.p(" S  M Tu  W Th  F  S");

        // starting day
        int d = dayOfWeek(this.monthNumber,1, this.year);

        // print the calendar
        for (int i = 0; i < d; i++) {
            //StdOut.print("   ");
            //Main.p("   ");
            System.out.print("   ");
        }
        //for (int i = 1; i <= days[month]; i++) {
        for(int i= 1; i<= this.numOfDays; i++) {
            //StdOut.printf("%2d ", i);
            System.out.printf("%2d ", i);
            //if (((i + d) % 7 == 0) || (i == days[month])) StdOut.println();
            if(((i + d) % 7 == 0) || (i == this.numOfDays)){
                //Main.p("");
                System.out.println();
            }
        }
    }



    public Week_ getWeek(int weekNum){
        for(Week_ week_ : weeksList){
            if(weekNum == week_.getWeekNumber()){
                return week_;
            }
        }
        return null;
    }

    //Helper Method

    //https://introcs.cs.princeton.edu/java/21function/Calendar.java.html
    /***************************************************************************
     *  Given the month, day, and year, return which day
     *  of the week it falls on according to the Gregorian calendar.
     *  For month, use 1 for January, 2 for February, and so forth.
     *  Returns 0 for Sunday, 1 for Monday, and so forth.
     ***************************************************************************/
    private int dayOfWeek(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

}
