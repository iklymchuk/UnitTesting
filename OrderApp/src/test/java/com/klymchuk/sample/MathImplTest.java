package com.klymchuk.sample;

import com.klymchuk.sample.Math;
import com.klymchuk.sample.MathImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by iklymchuk on 2/17/17.
 */
public class MathImplTest {

    private Math math;

    @Before
    public void setUp() {
        math = new MathImpl();
    }

    @Test
    public void mathShouldReturnValidOutput() {
        int sum = math.sum(1, 1);
        assertNotNull(sum);
        assertEquals(2, sum);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dividedShouldReturnException() {
        math.divided(1, 0);
    }

    @After
    public void tearDown() {
        math = null;
    }
}
