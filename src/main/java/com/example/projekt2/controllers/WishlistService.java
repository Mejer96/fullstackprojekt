package com.example.projekt2.controllers;

public class WishlistService {
    private Repository repository;

    public WishlistService(Repository repository) {
        this.repository = repository;
    }

    public void createWishlist(String name, String description, String user_ID) {
        repository.createWishlist(name, description, user_ID);

    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }
}
