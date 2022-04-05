package com.example.projekt2.controllers;

import java.sql.SQLException;

public class UserService {
    private Repository repository;

    public UserService(Repository repository) {
        this.repository = repository;
    }

    public User userLogin(String username, String password) throws SQLException {
        User user = null;

        if (repository.checkPassword(password).next() & repository.checkUsername(username).next()) {
            user = repository.getUser(username, password);
        }
        return user;
    }


    public boolean createUser(String username, String password) throws SQLException {
        boolean isValid = true;

        if (!repository.checkUsername(username).next()) {
            repository.createUser(username, password);
        } else {
            isValid = false;
        }
        return isValid;
    }
}
