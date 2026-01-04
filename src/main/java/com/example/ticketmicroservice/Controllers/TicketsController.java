package com.example.ticketmicroservice.Controllers;

import com.example.ticketmicroservice.Entities.Tickets;
import com.example.ticketmicroservice.Services.TicketsService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getById/{id}")
    public Tickets getById(@PathVariable Long id){
        return ticketsService.getTicketById(id);
    }

    @PostMapping("/create")
    public Tickets create(@RequestBody Tickets tickets){
        return ticketsService.saveTicket(tickets);
    }

    @PatchMapping("/closeTicket/{id}")
    public void close(@PathVariable Long id){
        ticketsService.closeTicket(id);
    }

    @PatchMapping("/changePriority/{id}/{priority}")
    public void changePriority(@PathVariable Long id, @PathVariable String priority){
        ticketsService.changePriority(id, priority);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ticketsService.deleteTicket(id);
    }



}
