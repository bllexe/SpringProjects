package org.tigris.springbootadmin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tigris.springbootadmin.modal.Ticket;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private List<Ticket> ticketList;

    @GetMapping
    public List<Ticket> getTicketList(){
        logger.info("getting all tickets");
        return ticketList;
    }

    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket){

        ticket.setId(ticketList.size()+1);
        logger.info("adding new ticket");
        ticketList.add(ticket);
        return ticket;
    }

}
