package com.example.projekt2.controllers;

public class Wishlist {
    private String wishlistName;
    private String wishlistDescription;
    private String wishlistID;

    public Wishlist(String wishlistName, String wishlistDescription, String wishlistID) {
        this.wishlistName = wishlistName;
        this.wishlistDescription = wishlistDescription;
        this.wishlistID = wishlistID;
    }

    public String getName() {
        return wishlistName;
    }

    public void setName(String name) {
        this.wishlistName = name;
    }

    public String getWishlistDescription() {
        return wishlistDescription;
    }

    public void setDescription(String wishlistDescription) {
        this.wishlistDescription = wishlistDescription;
    }

    public String getwishlistID() {
        return wishlistID;
    }

    public void setWishlistID(String wishlistID) {
        this.wishlistID = wishlistDescription;
    }
}
