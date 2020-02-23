package com.company.calendar;

import java.util.Date;
import java.util.List;

/*

    Named the Calendar_, because I also using Calendar from "java.util.Calendar"


 */
public class Calendar_ {

    //static
    private static int numOfObjects;

    //private
    private String calendarId;
    private CalendarTypeEnum calendarType;
    private TimezoneEnum timezone;
    private int year;
    private String calendarName;
    private String ownedBy; //user id of owner
    private String description;
    private boolean isDeleted; //soft delete
    private boolean isPublic; //if false, calendar is private
    private List<String> sharedWithList; //list of user ids
    private ThemeEnum theme;
    private String imageFileName;

    //Year object       //not to be confused with year, which contains the numerical value of the current year
    private Year_ year_;


    //constructor
    public Calendar_(String userId,
                     CalendarTypeEnum calendarType,
                     int year,
                     String calendarName,
                     String ownedBy,
                     String description) {

        //create calendarId
        int newID = numOfObjects + 1;
        String calendarId =
                userId + "_" + calendarType.name() + "_" + newID;

        this.calendarId = calendarId;
        this.calendarType = calendarType;
        this.year = year;
        this.calendarName = calendarName;
        this.ownedBy = ownedBy;
        this.description = description;

        //update object counter
        numOfObjects++;

        //create year object
        this.year_= new Year_(
                this.calendarId,
                this.year
        );
    }


    //getters and setters


    public String getCalendarName() {
        return calendarName;
    }

    //methods

    //get month
    public Year_ getYear(){
        return this.year_;
    }


    /*
        change the time zone of calendar
        use TimezoneEnum
     */
    public void setTimezone(TimezoneEnum timezone){
        this.timezone = timezone;
    }

    /*
        change theme of calendar {Dark, Light}
        use ThemeEnum
     */
    public void setTheme(ThemeEnum theme){
        this.theme = theme;
    }

    /*
        private, only owner can access calendar
        public, all users of calendar app can access calendar
     */
    public void setPublic(boolean isPublic){
        this.isPublic = isPublic;
    }


}
