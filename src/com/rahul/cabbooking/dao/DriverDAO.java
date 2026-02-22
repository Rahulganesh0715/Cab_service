package com.rahul.cabbooking.dao;


	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rahul.cabbooking.model.Driver;
import com.rahul.cabbooking.util.DBConnection;

	public class DriverDAO {

	    public void addDriver(Driver driver) {
	    	String sql = "insert into driver(name, phone) values (?, ?)";

	    
	        try (Connection con = DBConnection.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	        	ps.setString(1, driver.getName());
		    	ps.setString(2, driver.getPhone());
	            ps.executeUpdate();
	            System.out.println("Driver Added");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Driver> getAvailableDrivers() {
	        List<Driver> list = new ArrayList<>();
	        String sql = "SELECT * FROM driver WHERE available = true";

	        try (Connection con = DBConnection.getConnection();
	             Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery(sql)) {

	            while (rs.next()) {
	                list.add(new Driver(
	                        rs.getInt("driver_id"),
	                        rs.getString("name"),
	                        rs.getString("phone"),
	                        rs.getBoolean("available")
	                ));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	}

