package org.tigris.springbootadmin.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tigris.springbootadmin.modal.Ticket;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TicketInitialization {

    @Bean
    public List<Ticket> tickets() {
        List<Ticket> ticketList = new ArrayList<>();

        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        ticket1.setType("flight");
        ticket1.setPrice(100.0);

        Ticket ticket2 = new Ticket();
        ticket2.setId(2L);
        ticket2.setType("train");
        ticket2.setPrice(200.0);

        Ticket ticket3 = new Ticket();
        ticket3.setId(3L);
        ticket3.setType("car");
        ticket3.setPrice(300.0);

        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);

        return ticketList;
    }
}
