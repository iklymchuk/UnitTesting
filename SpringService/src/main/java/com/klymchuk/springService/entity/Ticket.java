package com.klymchuk.springService.entity;

/**
 * Created by iklymchuk on 3/6/17.
 */
public class Ticket {

    private String passengerName;
    private String phone;

    public String getPassengerName() {
        return passengerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
