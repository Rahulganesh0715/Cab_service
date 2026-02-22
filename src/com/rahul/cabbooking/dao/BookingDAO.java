package com.rahul.cabbooking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.rahul.cabbooking.model.Booking;

public class BookingDAO {

    public void createBooking(Connection con, Booking booking) throws Exception {

        String sql = "INSERT INTO booking(user_id,cab_id,pickup_location,drop_location,status,booking_time) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getCabId());
            ps.setString(3, booking.getPickupLocation());
            ps.setString(4, booking.getDropLocation());
            ps.setString(5, booking.getStatus());
            ps.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));

            ps.executeUpdate();
        }
    }
}