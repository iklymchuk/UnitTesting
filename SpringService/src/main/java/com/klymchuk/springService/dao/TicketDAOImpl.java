package com.klymchuk.springService.dao;

import com.klymchuk.springService.entity.Ticket;
import org.springframework.stereotype.Component;

/**
 * Created by iklymchuk on 3/6/17.
 */
@Component
public class TicketDAOImpl implements TicketDAO {

    public int createTicket(Ticket ticket) {
        return 1;
    }
}
