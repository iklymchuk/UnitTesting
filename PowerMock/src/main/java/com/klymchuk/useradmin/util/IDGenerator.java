package com.klymchuk.useradmin.util;

/**
 * Created by iklymchuk on 3/3/17.
 */
public final class IDGenerator {

    static int i;

    public static final int generateID() {
        return i++;
    }
}


