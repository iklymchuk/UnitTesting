package com.klymchuk.springService.service;

import com.klymchuk.springService.dao.TicketDAO;
import com.klymchuk.springService.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by iklymchuk on 3/6/17.
 */
@Component
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDAO dao;

    public int buyTicket(String passengerName, String phone) {

        Ticket ticket = new Ticket();
            ticket.setPassengerName("Ivan Klymchuk");
            ticket.setPhone("+380933333333");

        return dao.createTicket(ticket);
    }

    public TicketDAO getDao() {
        return dao;
    }

    public void setDao(TicketDAO dao) {
        this.dao = dao;
    }
}
