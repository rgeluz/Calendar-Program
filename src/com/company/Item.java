package com.company;

public class Item {

    //static
    private static int numOfObjects;


    //private
    private String itemId;
    private String itemName;
    private String itemDescription;
    private boolean isCompleted;

    //constructor
    public Item(String itemName, String itemDescription) {

        //create itemId
        int newID = numOfObjects + 1;
        String itemId = itemName + "_" + newID;

        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    //getter and setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


    //methods

    //TODO Finish Later
    public void displayItem() {

    }

    public void setToComplete(){
        this.isCompleted = true;
    }

}
