package com.example.projekt2.controllers;

import java.sql.*;

public class Repository {
    public Connection connection = connectToMySQL();

    // wish, wishlist og user ID's bliver automatisk tilføjet af MySQL,
    // så denne er ikke nødvendig som parameter
    // Link: https://www.w3schools.com/mysql/mysql_autoincrement.asp


    public Connection connectToMySQL() {
        Connection connection = null;
        try {
            // URL kommer til at skulle udskiftes, når vi engang får hostet databasen på azure.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wishlist_database", "root", "fullstackpassword123#");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet createQuery(String queryString, Statement statement) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(queryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public Statement createStatement() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public ResultSet checkUsername(String username) {
        Statement statement = createStatement();
        String mySQLStatement = "SELECT * FROM wishlist_database WHERE username='" + username+ "'";
        return createQuery(mySQLStatement, statement);
    }

    public ResultSet checkPassword(String password) {
        Statement statement = createStatement();
        String mySQLStatement = "SELECT * FROM wishlist_database WHERE username='" + password + "'";
        return createQuery(mySQLStatement, statement);
    }


    public void createUser(String username, String password) {
        Statement statement = createStatement();
        String mySQLStatement = "INSERT INTO users (username, user_password) VALUES (" + username + "," + password + ")";
        createQuery(mySQLStatement, statement);
    }

    public void createWish(String name, int price, String description, String wishlistID) {
        Statement statement = createStatement();
        String mySQLStatement = "INSERT INTO wish (item_name, item_price, item_description, wishlist_ID) VALUES (" + name + "," + price + "," + description + "," + wishlistID + ")";
        createQuery(mySQLStatement, statement);

    }

    public void deleteWish(String wish_ID) {
        Statement statement = createStatement();
        String mySQLStatement = "DELETE FROM wishlist WHERE wish_ID='" + wish_ID + "'";
        createQuery(mySQLStatement, statement);
    }


    public void createWishlist(String name, String description, String user_ID) {
        Statement statement = createStatement();
        String mySQLStatement = "INSERT INTO wishlist (wishlist_name, wishlist_description, user_ID) VALUES (" + name + "," + description + "," + user_ID + ")";
        createQuery(mySQLStatement, statement);
    }

    public void deleteWishlist(String wishlist_ID) {
        Statement statement = createStatement();
        String mySQLStatement = "DELETE FROM wishlist WHERE wishlist_ID='" + wishlist_ID + "'";
        createQuery(mySQLStatement, statement);
    }
}
