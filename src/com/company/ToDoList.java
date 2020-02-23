package com.company;

import java.util.List;

public class ToDoList {

    //static
    private static int numOfObjects;


    //private
    private String toDoListId;
    private String listName;
    private List<Item> itemsLists;

    //constructor
    public ToDoList(String listName) {

        //create new toDoListId;
        int newID = numOfObjects +1;
        String toDoListId = listName + "_" + newID;

        this.toDoListId = toDoListId;
        this.listName = listName;
    }

    //methods
    public void addItem(String name, String description) {
        Item newItem = new Item(name, description);
        this.itemsLists.add(newItem);
    }

    public void updateItem(){

    }

    //decide not to delete, rather soft delete instead
    public void setItemToComplete(String itemId){
        for(Item item : this.itemsLists) {
            if(item.getItemId().equals(itemId)) {
                item.setToComplete();
            }
        }
    }
}
