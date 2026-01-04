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

    public List<Tickets> getAllTickets(){
        return ticketsRepository.findAll();
    }


}
