package com.example.ticketmicroservice.Services;

import com.example.ticketmicroservice.Entities.Tickets;
import com.example.ticketmicroservice.Repositories.TicketsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketsService {
    private final TicketsRepository ticketsRepository;

    public TicketsService(TicketsRepository ticketsRepository){
        this.ticketsRepository = ticketsRepository;
    }

    // Get All
    public List<Tickets> getAllTickets(){
        return ticketsRepository.findAll();
    }

    // Get by ID
    public Tickets getTicketById(Long id){
        return ticketsRepository.findById(id).orElse(null);
    }

    // Create
    public Tickets saveTicket(Tickets tickets){
        return ticketsRepository.save(tickets);
    }

    // Close Status
    public void closeTicket(Long id){
        Tickets ticket = ticketsRepository.findById(id).orElse(null);

        if (ticket != null){
            ticket.setStatus("CLOSED");
            ticketsRepository.save(ticket);
        }
    }

    // Change Priority
    public void changePriority(Long id, String priority){
        Tickets tickets = ticketsRepository.findById(id).orElse(null);

        if (tickets != null){
            tickets.setPriority(priority);
            ticketsRepository.save(tickets);
        }
    }

    // Delete
    public void deleteTicket(Long id){
        ticketsRepository.deleteById(id);
    }



}
