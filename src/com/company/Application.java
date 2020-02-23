package com.company;

import com.company.calendar.Day_;
import com.company.calendar.TimezoneEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Application {

    //private
    private static Application application;
    private TimezoneEnum timezone;
    private String usernameLoggedOn;
    private List<User> userList;

    //constructor
    /*
        Design Pattern: Singleton
        changed access modifier from public to private
     */
    private Application(TimezoneEnum timezone) {
        this.timezone = timezone;
        this.userList = new ArrayList<User>();

        createDefaultUser();

    }

    public static Application getInstance(TimezoneEnum timezone) {
        if(application == null){
            application = new Application(timezone);
        }
        return application;
    }

    //getters and setters

    public TimezoneEnum getTimezone() {
        return timezone;
    }

    public void setTimezone(TimezoneEnum timezone) {
        this.timezone = timezone;
    }

    public String getUsernameLoggedOn() {
        return usernameLoggedOn;
    }

    public void setUsernameLoggedOn(String usernameLoggedOn) {
        this.usernameLoggedOn = usernameLoggedOn;
    }



    public List<User> getUserList() {
        List<User> readOnlyUserList = Collections.unmodifiableList(this.userList);
        //return userList;
        return readOnlyUserList;
    }

    //methods

    //add new user to user list
    public void addNewUser(User user){
        this.userList.add(user);
    }

    //create a default user
    private void createDefaultUser(){
        String username = "defaultUser";
        String firstname = "default";
        String lastname = "user";
        User newuser = new User(username, firstname, lastname);

        //create default calendar for new user
        String calendarName = "defaultCal";
        String description = "this is used for testing.";
        newuser.createCalendar(calendarName, description);

        //create default events
        Event event1 = new Event("Event 1",
                                new Date(2020, 02, 01),
                                new Date(2020, 02,01),
                                "Event 1 description",
                                newuser.getUserId()
                );
        Event event2 = new Event("Event 2",
                new Date(2020, 02, 01),
                new Date(2020, 02,01),
                "Event 2 description",
                newuser.getUserId()
        );
        Event event3 = new Event("Event 3",
                new Date(2020, 02, 01),
                new Date(2020, 02,01),
                "Event 3 description",
                newuser.getUserId()
        );
        Event event4 = new Event("Event 4",
                new Date(2020, 02, 01),
                new Date(2020, 02,01),
                "Event 4 description",
                newuser.getUserId()
        );


        Day_ day_ = newuser.getCalendarsOwned().get(0). //get defaultCal calendar
                getYear().
                getMonth("January").
                getWeek(1).  //weekNumber = 1, weeksList[0] zero index
                getDaysList().get(0);  //dayList[0], dayNumber = 1, WEDNESDAY, dayOfWeekNumber = 3,
        day_.addEvent(event1);
        day_.addEvent(event2);
        day_.addEvent(event3);
        day_.addEvent(event4);


        this.userList.add(newuser);
    }

}
