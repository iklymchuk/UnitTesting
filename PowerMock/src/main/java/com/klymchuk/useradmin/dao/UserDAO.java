package com.klymchuk.useradmin.dao;

import com.klymchuk.useradmin.dto.User;
import com.klymchuk.useradmin.util.IDGenerator;

/**
 * Created by iklymchuk on 3/3/17.
 */
public class UserDAO {

    public int create(User user) {
        int id = IDGenerator.generateID();
        /*
        user.setId(id);
        return user.getId();
        */
        return id;
    }
}
