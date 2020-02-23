package com.company;

public class NullUser extends User {

    public NullUser(String username, String firstname, String lastname) {
        super(username, firstname, lastname);
    }

    boolean isNull(){
        return true;
    }

}
