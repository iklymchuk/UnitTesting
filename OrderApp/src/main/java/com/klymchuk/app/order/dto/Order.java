package com.klymchuk.app.order.dto;

/**
 * Created by iklymchuk on 2/20/17.
 */
public class Order {

    private int id;
    private String status;

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
