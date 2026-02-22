package com.rahul.cabbooking.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rahul.cabbooking.util.DBConnection;

public class BookingService {

	public void bookCab(int userId, int cabId, String pickup, String drop) {

	    try (Connection con = DBConnection.getConnection()) {

	        con.setAutoCommit(false);  // Start Transaction

	        // Lock selected cab row
	        String lockQuery = "SELECT * FROM cab WHERE cab_id = ? FOR UPDATE";
	        PreparedStatement lockStmt = con.prepareStatement(lockQuery);
	        lockStmt.setInt(1, cabId);
	        ResultSet rs = lockStmt.executeQuery();

	        if (rs.next() && rs.getBoolean("available")) {

	            // 1️⃣ Update cab availability
	            String updateCab = "UPDATE cab SET available = false WHERE cab_id = ?";
	            PreparedStatement ps1 = con.prepareStatement(updateCab);
	            ps1.setInt(1, cabId);
	            ps1.executeUpdate();

	            // 2️⃣ Insert booking properly
	            String insertBooking = 
	                "INSERT INTO booking(user_id,cab_id,pickup_location,drop_location,status) VALUES(?,?,?,?,?)";

	            PreparedStatement ps2 = con.prepareStatement(insertBooking);
	            ps2.setInt(1, userId);
	            ps2.setInt(2, cabId);
	            ps2.setString(3, pickup);
	            ps2.setString(4, drop);
	            ps2.setString(5, "BOOKED");
	            ps2.executeUpdate();

	            con.commit();
	            System.out.println("Cab Booked Successfully ✅");

	        } else {
	            System.out.println("Cab Not Available ❌");
	            con.rollback();
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}}