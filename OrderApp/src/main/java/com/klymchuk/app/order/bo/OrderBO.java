package com.klymchuk.app.order.bo;

import com.klymchuk.app.order.bo.exception.BOException;
import com.klymchuk.app.order.dto.Order;

/**
 * Created by iklymchuk on 2/20/17.
 */
public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;

    boolean cancelOrder(int id) throws BOException;

    boolean deleteOrder(int id) throws BOException;
}


