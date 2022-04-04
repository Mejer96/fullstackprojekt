package com.example.projekt2.controllers;

public class Wishlist {
    private String name;
    private String description;
    private String ID;
    private String user_ID;

    public Wishlist(String name, String description, String ID, String user_ID) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.user_ID = user_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }
}
