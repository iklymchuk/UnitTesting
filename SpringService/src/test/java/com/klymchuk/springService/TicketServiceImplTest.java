package com.klymchuk.springService;

import com.klymchuk.springService.dao.TicketDAO;
import com.klymchuk.springService.entity.Ticket;
import com.klymchuk.springService.service.TicketServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by iklymchuk on 3/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {

    private static final int RESULT = 1;
    private static final String PHONE = "Ivan Klymchuk";
    private static final String PASSANGER_NAME = "+380933333333";

    @Mock
    TicketDAO dao;

    @Autowired
    @InjectMocks
    private TicketServiceImpl service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void buyTicketsShouldReturnsValidValue() {
        when(dao.createTicket(any(Ticket.class))).thenReturn(1);

        /* create object use @Autowired
        service = new TicketServiceImpl();
        *
        * to
        * @Autowired
        private TicketServiceImpl service;
        */

        int result = service.buyTicket(PASSANGER_NAME, PHONE);
        assertEquals(result, RESULT);
    }
}

