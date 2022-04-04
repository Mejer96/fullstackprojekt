package com.example.projekt2.controllers;

public class Wish {
    private String name;
    private float price;
    private String description;
    private String ID;

    public Wish(String name, float price, String description, String ID) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
