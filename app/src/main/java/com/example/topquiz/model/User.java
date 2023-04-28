package com.example.topquiz.model;

import java.util.List;

public class User {


    private String mFirstName;

    public User (String mFirstName){
        this.mFirstName = mFirstName;
    }



    /******** Setters ********/

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    /******** Getters ********/

    public String getFirstName() {
        return mFirstName;
    }



}
