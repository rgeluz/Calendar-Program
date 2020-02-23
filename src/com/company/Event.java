package com.company;

import java.util.Date;
import java.util.List;

public class Event {

    //static
    private static int numOfObjects;

    //private
    private String eventId;
    private String eventTitle;
    private Date eventStartDate;
    private Date eventEndDate;
    private String description;
    private String ownedBy; //userid of owner
    private String eventLocation;
    private boolean isDeleted; //soft delete
    private List<String> sharedWithList; //list of user ids
    private String imageFileName;
    private boolean isAlertOn;


    //constructor
    /*
        add/update other fields later
     */
    public Event(String eventTitle,
                 Date eventStartDate,
                 Date eventEndDate,
                 String description,
                 String userId) {

        //create eventId
        int newID = numOfObjects +1;
        String eventId = userId + "_" + newID;

        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.description = description;
        this.ownedBy = userId;

        //update object counter
        numOfObjects++;
    }

    //get and setter


    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    //methods
    public void setStartAndEndDate(Date start, Date end){
        this.eventStartDate = start;
        this.eventEndDate = end;
    }

    public void setLocation(String location){
        this.eventLocation = location;
    }

    //Only add user ids that are not already in list
    public void addInvitees(List<String> newUserIds){
        for(String newUserId : newUserIds ){
            boolean notInList = true;
            for(String existingUserId: this.sharedWithList) {
                if( existingUserId.equals(newUserId) ) {
                    notInList = false;
                }
            }
            if(notInList){ //if not in list add to list
                this.sharedWithList.add(newUserId);
            }
        }
    }

    //TODO: Finish Later
    public void addNotesURLorAttachments(){

    }


}
