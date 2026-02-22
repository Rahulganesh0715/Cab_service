package com.rahul.cabbooking.dao;



	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rahul.cabbooking.model.Cab;
import com.rahul.cabbooking.util.DBConnection;

	public class CabDAO {

	    public void addCab(Cab cab) {
	        String sql = "INSERT INTO cab(cab_number,cab_type,available,driver_id) VALUES(?,?,?,?)";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, cab.getCabNumber());
	            ps.setString(2, cab.getCabType());
	            ps.setBoolean(3, cab.isAvailable());
	            ps.setInt(4, cab.getDriverId());

	            ps.executeUpdate();
	            System.out.println("Cab Added");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public Cab getCabById(int id) {
	        String sql = "SELECT * FROM cab WHERE cab_id = ?";
	        Cab cab = null;

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                cab = new Cab(
	                        rs.getInt("cab_id"),
	                        rs.getString("cab_number"),
	                        rs.getString("cab_type"),
	                        rs.getBoolean("available"),
	                        rs.getInt("driver_id")
	                );
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return cab;
	    }

	    public void updateCabAvailability(int cabId, boolean status) {
	        String sql = "UPDATE cab SET available = ? WHERE cab_id = ?";

	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setBoolean(1, status);
	            ps.setInt(2, cabId);
	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
