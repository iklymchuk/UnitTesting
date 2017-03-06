package com.klymchuk.app.order.dao;

import com.klymchuk.app.order.dto.Order;

import java.sql.SQLException;

/**
 * Created by iklymchuk on 2/20/17.
 */
public interface OrderDAO {

    int create(Order order) throws SQLException;

    Order read(int id) throws SQLException;

    int update(Order order) throws SQLException;

    int delete(int id) throws SQLException;
}
