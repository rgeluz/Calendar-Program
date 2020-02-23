package com.company.calendar;

import java.util.ArrayList;
import java.util.List;

public class Year_ extends Period_ {

    //static
    private static int numOfObjects;

    //private
    private String yearId;
    private int year;
    private List<Month_> monthsList;

    //constructor
    public Year_(String calendarId,
                 int year) {

        //create yearId
        int newID = numOfObjects + 1;
        String yearId =
                calendarId + "_" + year + "_" + newID;

        this.yearId = yearId;
        this.year = year;
        this.monthsList = new ArrayList<Month_>();

        //update object counter
        numOfObjects++;

        //add months to the months list
        createMonthList();
    }

    //methods

    /*
        add all the months of the year
     */
    private void createMonthList(){
        MonthEnum monthsEnumArray[] = MonthEnum.values();
        for(MonthEnum monthEnum: monthsEnumArray){
            Month_ newMonth = new Month_(this.yearId, this.year, monthEnum);
            monthsList.add(newMonth);
        }
    }


    @Override
    public void displayView() {
        displayYearView();
    }

    private void displayYearView(){
        for(Month_ month_ : monthsList){
            //month_.displayMonthView();
            month_.displayView();
            System.out.println(" ");
        }
    }

    public Month_ getMonth(String month){
        for(Month_ month_ : monthsList){
            String monthName = month_.getMonthOfYear().name().toLowerCase();
            if(monthName.equals(month.toLowerCase())){
                return month_;
            }
        }
        return null;
    }



}
