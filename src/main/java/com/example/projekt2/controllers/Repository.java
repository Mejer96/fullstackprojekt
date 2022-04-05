package com.example.projekt2.controllers;

import java.sql.*;
import java.util.ArrayList;

public class Repository {
    private Connection connection = connectToMySQL();

    // wish, wishlist og user ID's bliver automatisk tilføjet af MySQL,
    // så denne er ikke nødvendig som parameter
    // Link: https://www.w3schools.com/mysql/mysql_autoincrement.asp

    public Connection connectToMySQL() {
        Connection connection = null;
        try {
            // URL kommer til at skulle udskiftes, når vi engang får hostet databasen på azure.
            // virker ikke uden jar fil med jdbc driver.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wishlists_database", "root", "fullstackpassword123#");
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
        String mySQLStatement = "SELECT * FROM users WHERE username='" + username + "'";
        return createQuery(mySQLStatement, statement);
    }

    public ResultSet checkPassword(String password) {
        Statement statement = createStatement();
        String mySQLStatement = "SELECT * FROM users WHERE password='" + password + "'";
        return createQuery(mySQLStatement, statement);
    }

    public User getUser(String username, String password) throws SQLException {
        User user = null;
        Statement statement = createStatement();
        String mySQLStatement = "SELECT * FROM users WHERE password='" + password + " AND username ='" + username + "'";
        ResultSet resultSet = createQuery(mySQLStatement, statement);

        while (resultSet.next()) {
            user = new User(resultSet.getString("username"), resultSet.getString("user_ID"));
        }
        return user;
    }

    public void createUser(String username, String password) throws SQLException {
        Statement statement = createStatement();
        String mySQLStatement = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password + "')";
        statement.executeUpdate(mySQLStatement);
    }

    public ArrayList<Wish> getWishlistItems(String wishlist_ID) throws SQLException {
        ArrayList<Wish> wishlist_items = new ArrayList<>();
        Statement statement = createStatement();
        String mySQLStatement = "SELECT * FROM wish WHERE wishlist_ID='" + wishlist_ID + "'";
        ResultSet resultSet = createQuery(mySQLStatement, statement);

        while (resultSet.next()) {
            Wish wish = new Wish(resultSet.getString("wish_name"), resultSet.getString("wish_price"), resultSet.getString("wish_description"));
            wishlist_items.add(wish);
        }
        return wishlist_items;
    }

    public ArrayList<Wishlist> getWishlists(String user_ID) throws SQLException {
        ArrayList<Wishlist> wishlists = new ArrayList<>();
        Statement statement = createStatement();
        String mySQLStatement = "SELECT * FROM wishlist WHERE user_ID='" + user_ID + "'";
        ResultSet resultSet = createQuery(mySQLStatement, statement);

        while (resultSet.next()) {
            Wishlist wishlist = new Wishlist(resultSet.getString("wishlist_name"), resultSet.getString("wishlist_description"), resultSet.getString("wishlist_ID"));
            wishlists.add(wishlist);
        }
        return wishlists;
    }

    public void createWish(String itemName, String itemPrice, String itemDescription, String wishlistID) throws SQLException {
        Statement statement = createStatement();
        String mySQLStatement = "INSERT INTO wish (item_name, item_price, item_description, wishlist_ID) VALUES (" + itemName + "," + itemPrice + "," + itemDescription + "," + wishlistID + ")";
        statement.executeUpdate(mySQLStatement);
    }

    public void deleteWish(String wishID) throws SQLException {
        Statement statement = createStatement();
        String mySQLStatement = "DELETE FROM wish WHERE wish_ID='" + wishID + "'";
        statement.executeUpdate(mySQLStatement);
    }


    public void createWishlist(String wishlistName, String wishlistDescription, String userID) throws SQLException {
        Statement statement = createStatement();
        String mySQLStatement = "INSERT INTO wishlist (wishlist_name, wishlist_description, user_ID) VALUES (" + wishlistName + "," + wishlistDescription + "," + userID + ")";
        statement.executeUpdate(mySQLStatement);
    }

    public void deleteWishlist(String wishlist_ID) throws SQLException {
        Statement statement = createStatement();
        String mySQLStatement = "DELETE FROM wishlist WHERE wishlist_ID='" + wishlist_ID + "'";
        statement.executeUpdate(mySQLStatement);
    }
}
