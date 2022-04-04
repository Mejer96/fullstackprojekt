package com.example.projekt2.controllers;

public class Wishlist {
    private String name;
    private String description;
    private String ID;

    public Wishlist(String name, String description, String ID) {
        this.name = name;
        this.description = description;
        this.ID = ID;
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
}
