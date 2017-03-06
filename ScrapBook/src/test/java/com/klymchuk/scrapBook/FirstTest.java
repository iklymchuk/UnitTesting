package com.klymchuk.scrapBook;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertSame;

import static org.mockito.Mockito.*;

/**
 * Created by iklymchuk on 3/1/17.
 */
public class FirstTest {

    //Implicitly stab
    @Mock
    Second second;
    private First first;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        first = new First(second);
    }

    @Test
    public void usesSampleMethodShouldCallTheMethod() throws Exception {
        //Explicitly stab
        doNothing().when(second).secondMethodDeclaration();
        assertSame(1, first.firstMethodImplementation());
        verify(second).secondMethodDeclaration();
    }

    @Test(expected = RuntimeException.class)
    public void usesSampleMethodShouldThrowRuntimeException() throws Exception {
        doThrow(RuntimeException.class).when(second).secondMethodDeclaration();
        second.secondMethodDeclaration();

        first.firstMethodImplementation();
    }

    @Test(expected = RuntimeException.class)
    public void testConsecutiveCalls() throws Exception {
        doThrow(RuntimeException.class).when(second).secondMethodDeclaration();
        second.secondMethodDeclaration();

        first.firstMethodImplementation();
        verify(second).secondMethodDeclaration();
        first.firstMethodImplementation();
    }
}
