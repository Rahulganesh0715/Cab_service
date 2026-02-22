package com.rahul.cabbooking.model;

public class Driver {

    private int driverId;
    private String name;
    private String phone;
    private boolean available;

    public Driver() {}

    public Driver(int driverId, String name, String phone, boolean available) {
        this.driverId = driverId;
        this.name = name;
        this.phone = phone;
        this.available = available;
    }



    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Driver [driver_id=" + driverId +
               ", name=" + name +
               ", phone=" + phone +
               ", is_available=" + available + "]";
    }
}