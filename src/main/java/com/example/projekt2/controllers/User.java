package com.example.projekt2.controllers;

public class User {
    private String username;
    private final String user_ID;


    public User(String username, String user_ID) {
        this.username = username;
        this.user_ID = user_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
