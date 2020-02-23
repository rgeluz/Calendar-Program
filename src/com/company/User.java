package com.company;


import java.util.ArrayList;
import java.util.Calendar;
import com.company.calendar.Calendar_;
import com.company.calendar.CalendarTypeEnum;

import java.util.Date;
import java.util.List;

public class User {

    //static
    private static int numOfObjects;


    //private
    private String userId;
    private String username;
    private String firstname;
    private String lastname;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private List<Calendar_> calendarsOwned; //list of calendars created by user
    private List<Event> eventsOwned; //list of events created by user


    //constructor
    /*
        set the other fields after creation
     */
    public User(String username,
                String firstname,
                String lastname) {
        //create userId
        int newID = numOfObjects + 1;
        String userId = username + "_" + newID;

        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.calendarsOwned = new ArrayList<Calendar_>();
        this.eventsOwned = new ArrayList<Event>();

        //update object counter
        numOfObjects++;
    }

    boolean isNull(){
        return false;
    }

    //getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Calendar_> getCalendarsOwned() {
        return calendarsOwned;
    }

    public void setCalendarsOwned(List<Calendar_> calendarsOwned) {
        this.calendarsOwned = calendarsOwned;
    }

    public List<Event> getEventsOwned() {
        return eventsOwned;
    }


    public void setEventsOwned(List<Event> eventsOwned) {
        this.eventsOwned = eventsOwned;
    }


    //methods

    //TODO finish later
    public void createCalendar(String calendarName, String description) {
        /*
        https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java
         */
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Calendar_ newCalendar = new Calendar_(
                this.userId,
                CalendarTypeEnum.GREGORIAN_CALENDAR,
                year,
                calendarName,
                this.username,
                description
        );
        //add new calendar to the user's list of calendars
        calendarsOwned.add(newCalendar);
    }

    //TODO finish later
    public void updateCalendar(){

    }

    //TODO finish later
    public void deleteCalendar(){

    }

    //TODO finish later
    public void shareCalendar(){

    }

    //Create a new event
    /*
            ownedby is the user id
     */
    public void createEvent(String eventTitle, Date eventStartDate, Date eventEndDate, String description){
        Event event = new Event(
                eventTitle, eventStartDate, eventEndDate, description, this.userId
        );

    }

    //TODO finish later
    public void updateEvent(String eventId){

    }

    //TODO finish later
    public void deleteEvent(){

    }

    //TODO finish later
    public void shareEvent(){

    }
}
