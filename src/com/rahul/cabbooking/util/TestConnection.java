package com.rahul.cabbooking.util;



import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/cabbooking",
                    "postgres",
                    "123"   // replace with your password
            );

            System.out.println("Database Connected Successfully!");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}