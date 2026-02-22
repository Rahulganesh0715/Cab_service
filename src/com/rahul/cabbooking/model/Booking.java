package com.rahul.cabbooking.model;


	import java.time.LocalDateTime;

	public class Booking {

	    private int bookingId;
	    private int userId;
	    private int cabId;
	    private String pickupLocation;
	    private String dropLocation;
	    private String status;
	    private LocalDateTime bookingTime;

	    public Booking() {}

	    public Booking(int bookingId, int userId, int cabId,
	                   String pickupLocation, String dropLocation,
	                   String status, LocalDateTime bookingTime) {
	        this.bookingId = bookingId;
	        this.userId = userId;
	        this.cabId = cabId;
	        this.pickupLocation = pickupLocation;
	        this.dropLocation = dropLocation;
	        this.status = status;
	        this.bookingTime = bookingTime;
	    }

	   

	    public int getBookingId() {
	        return bookingId;
	    }

	    public void setBookingId(int bookingId) {
	        this.bookingId = bookingId;
	    }

	    public int getUserId() {
	        return userId;
	    }

	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	    public int getCabId() {
	        return cabId;
	    }

	    public void setCabId(int cabId) {
	        this.cabId = cabId;
	    }

	    public String getPickupLocation() {
	        return pickupLocation;
	    }

	    public void setPickupLocation(String pickupLocation) {
	        this.pickupLocation = pickupLocation;
	    }

	    public String getDropLocation() {
	        return dropLocation;
	    }

	    public void setDropLocation(String dropLocation) {
	        this.dropLocation = dropLocation;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public LocalDateTime getBookingTime() {
	        return bookingTime;
	    }

	    public void setBookingTime(LocalDateTime bookingTime) {
	        this.bookingTime = bookingTime;
	    }

	    @Override
	    public String toString() {
	        return "Booking [bookingId=" + bookingId +
	               ", userId=" + userId +
	               ", cabId=" + cabId +
	               ", pickup=" + pickupLocation +
	               ", drop=" + dropLocation +
	               ", status=" + status +
	               ", time=" + bookingTime + "]";
	    }
	}

