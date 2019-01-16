package com.udacity.gradle.builditbigger.backend;

import com.udacity.gradle.builditbigger.Joke;

import java.util.ArrayList;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String theJoke = "";

    public String getJoke() {
        return theJoke;
    }

    public void setJoke(String inputJoke) {
        this.theJoke = inputJoke;
    }
}