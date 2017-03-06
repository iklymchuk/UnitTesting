package com.klymchuk.app.order.bo.exception;

import java.sql.SQLException;

/**
 * Created by iklymchuk on 2/20/17.
 */
public class BOException extends Exception {

    public BOException(SQLException e) {

        super(e);
    }
}
