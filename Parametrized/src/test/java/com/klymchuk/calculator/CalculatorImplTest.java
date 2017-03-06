package com.klymchuk.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by iklymchuk on 3/3/17.
 */
@RunWith(Parameterized.class)
public class CalculatorImplTest {

    private int num1;
    private int num2;
    private int expectedResult;

    //Test Constructor
    public CalculatorImplTest(int num1, int num2, int result) {
        this.num1 = num1;
        this.num2 = num2;
        this.expectedResult = result;
    }

    //Static parametrize method
    @Parameterized.Parameters
    public static Collection<Integer[]> data() {
        return Arrays.asList(new Integer[][]
                {
                        {-1,2,1},
                        {1,2,3},
                        {6,7,13},
                        {3,5,8}
                });
    }

    @Test
    public void addShouldReturnResult() {
        Calculator c = new CalculatorImpl();
        int result = c.add(num1, num2);
        assertEquals(expectedResult, result);
    }
}
