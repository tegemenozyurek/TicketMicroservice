package com.example.ticketmicroservice.Controllers;

import com.example.ticketmicroservice.Entities.Tickets;
import com.example.ticketmicroservice.Services.TicketsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketsController {
    private final TicketsService ticketsService;

    public TicketsController(TicketsService ticketsService){
        this.ticketsService = ticketsService;
    }

    @GetMapping("/getAll")
    public List<Tickets> getAll(){
        return ticketsService.getAllTickets();
    }
}
