package com.example.projekt2.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

public class WishlistService {
    private Repository repository;

    public WishlistService(Repository repository) {
        this.repository = repository;
    }

    public void createWishlist(String name, String description, String userID) throws SQLException {
        repository.createWishlist(name, description, userID);
    }

    public ArrayList<Wishlist> getWishlist(String userID) throws SQLException {
        return repository.getWishlists(userID);
    }

    public void createWish(String itemName, String itemPrice, String itemDescription, String wishlistID) throws SQLException {
        repository.createWish(itemName, itemPrice, itemDescription, wishlistID);
    }

    public ArrayList<Wish> getWishlistItems(String wishlistID) throws SQLException {
        return repository.getWishlistItems(wishlistID);
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
