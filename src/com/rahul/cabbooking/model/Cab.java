package com.rahul.cabbooking.model;

public class Cab {
	 private int cabId;
	    private String cabNumber;
	    private String cabType;
	    private boolean available;
	    private int driverId;

	    public Cab() {}

	    public Cab(int cabId, String cabNumber, String cabType,
	               boolean available, int driverId) {
	        this.cabId = cabId;
	        this.cabNumber = cabNumber;
	        this.cabType = cabType;
	        this.available = available;
	        this.driverId = driverId;
	    }

	    public Cab(String cabNumber, String cabType,
	               boolean available, int driverId) {
	        this.cabNumber = cabNumber;
	        this.cabType = cabType;
	        this.available = available;
	        this.driverId = driverId;
	    }

	    public int getCabId() {
	        return cabId;
	    }

	    public void setCabId(int cabId) {
	        this.cabId = cabId;
	    }

	    public String getCabNumber() {
	        return cabNumber;
	    }

	    public void setCabNumber(String cabNumber) {
	        this.cabNumber = cabNumber;
	    }

	    public String getCabType() {
	        return cabType;
	    }

	    public void setCabType(String cabType) {
	        this.cabType = cabType;
	    }

	    public boolean isAvailable() {
	        return available;
	    }

	    public void setAvailable(boolean available) {
	        this.available = available;
	    }

	    public int getDriverId() {
	        return driverId;
	    }

	    public void setDriverId(int driverId) {
	        this.driverId = driverId;
	    }

	    @Override
	    public String toString() {
	        return "Cab [cabId=" + cabId +
	               ", cabNumber=" + cabNumber +
	               ", cabType=" + cabType +
	               ", available=" + available +
	               ", driverId=" + driverId + "]";
	    }
}
