package com.rahul.cabbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rahul.cabbooking.model.User;
import com.rahul.cabbooking.util.DBConnection;

public class UserDAO {

    // Insert User
    public void registerUser(User user) {
        String sql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            ps.executeUpdate();
            System.out.println("User Registered Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get User by ID
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        User user = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Get All Users
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}