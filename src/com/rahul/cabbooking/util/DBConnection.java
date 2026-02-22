package com.rahul.cabbooking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/cabdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    // Static block (runs once when class loads)
    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}