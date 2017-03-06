package com.klymchuk.app.order.bo;

import com.klymchuk.app.order.bo.OrderBOImpl;
import com.klymchuk.app.order.bo.exception.BOException;
import com.klymchuk.app.order.dao.OrderDAO;
import com.klymchuk.app.order.dto.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by iklymchuk on 2/22/17.
 */
public class OrderBOImplTest {

    private OrderBOImpl bo;
    private static final int ORDER_ID = 123;

    @Mock
    OrderDAO dao;

    @Before 
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        bo = new OrderBOImpl();
        bo.setDao(dao);
    }

    @Test
    public void placeOrderShouldCreateOrder() throws SQLException, BOException {

        /*Verify mode
            *
            * Order order = new Order();
            * when(dao.update(order)).thenReturn(1);
            *
            * to
            * when(dao.update(any(Order.class))).thenReturn(1);
            *
         */
        Order order = new Order();
        when(dao.create(any(Order.class))).thenReturn(new Integer(1));
        boolean result = bo.placeOrder(order);

        assertTrue(result);

        //Verification Mode
        verify(dao, times(1)).create(order);
        verify(dao, atLeast(1)).create(order);
    }

    @Test
    public void placeOrderShouldNotCreateOrder() throws SQLException, BOException {

        Order order = new Order();
        when(dao.create(order)).thenReturn(new Integer(0));
        boolean result = bo.placeOrder(order);

        assertFalse(result);
        verify(dao).create(order);
    }

    @Test(expected = BOException.class)
    public void placeOrderShouldThrowBoException() throws SQLException, BOException {

        Order order = new Order();
        when(dao.create(order)).thenThrow(SQLException.class);
        boolean result = bo.placeOrder(order);
    }

    @Test
    public void cancelOrderShouldCancelTheOrder() throws SQLException, BOException {
        Order order = new Order();

        /*Verify mode
            *
            Mockito.any***
            *
            * Order order = new Order();
            * when(dao.update(order)).thenReturn(1);
            *
            * to
            * when(dao.update(any(Order.class))).thenReturn(1);
            *
         */
        when(dao.read(anyInt())).thenReturn(order);
        when(dao.update(any(Order.class))).thenReturn(1);
        boolean result = bo.cancelOrder(ORDER_ID);

        assertTrue(result);

        verify(dao).read(ORDER_ID);
        verify(dao).update(order);
    }

    @Test
    public void cancelOrderShouldNotCancelTheOrder() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(ORDER_ID)).thenReturn(order);
        when(dao.update(order)).thenReturn(0);
        boolean result = bo.cancelOrder(ORDER_ID);

        assertFalse(result);

        verify(dao).read(ORDER_ID);
        verify(dao).update(order);
    }

    @Test(expected = BOException.class)
    public void cancelOrderShouldThrowBoExceptionOnRead() throws SQLException, BOException {
        when(dao.read(ORDER_ID)).thenThrow(BOException.class);
        boolean result = bo.cancelOrder(ORDER_ID);
    }

    @Test(expected = BOException.class)
    public void cancelOrderShouldThrowBoExceptionOnUpdate() throws SQLException, BOException {
        Order order = new Order();
        when(dao.read(ORDER_ID)).thenReturn(order);
        when(dao.update(order)).thenThrow(BOException.class);
        boolean result = bo.cancelOrder(ORDER_ID);
    }

    @Test
    public void deleteOrder() throws SQLException, BOException {
        when(dao.delete(ORDER_ID)).thenReturn(1);
        boolean result = bo.deleteOrder(ORDER_ID);

        assertTrue(result);
        verify(dao).delete(ORDER_ID);
    }
}
