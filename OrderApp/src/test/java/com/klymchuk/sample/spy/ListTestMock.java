package com.klymchuk.sample.spy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertSame;

/**
 * Created by iklymchuk on 3/1/17.
 */
public class ListTestMock {

    @Mock
    List<String> myList = new ArrayList<>();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void listTestMockTest() {

        Mockito.when(myList.get(0)).thenReturn("Bro");

        //Mockito.doReturn(3).when(myList).size();

        assertSame("Bro", myList.get(0));

    }
}
