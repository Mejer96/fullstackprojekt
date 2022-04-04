package com.example.projekt2.controllers;

import java.sql.SQLException;

public class UserService {
    private Repository repository;

    public UserService(Repository repository) {
        this.repository = repository;
    }

    public boolean userLogin(String username, String password) throws SQLException {
        // work in progress.
        boolean isValid = true;

        if (!repository.checkPassword(password).next() & !repository.checkUsername(username).next()) {
            isValid = false;
        }
        return isValid;
    }

    public boolean createUser(String username, String password) throws SQLException {
        boolean isValid = true;

        if (repository.checkPassword(password).next() & repository.checkUsername(username).next()) {
            repository.createUser(username, password);
        } else {
            isValid = false;
        }
        return isValid;
    }
}
