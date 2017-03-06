package com.klymchuk.springService.dao;

import com.klymchuk.springService.entity.Ticket;

/**
 * Created by iklymchuk on 3/6/17.
 */
public interface TicketDAO {

    int createTicket(Ticket ticket);
}
