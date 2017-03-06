package com.klymchuk.sample;

/**
 * Created by iklymchuk on 2/17/17.
 */
public class MathImpl implements Math {

    public int sum(int a, int b) {
        return a+b;
    }

    public int divided(int a, int b) {

        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a/b;
    }
}
