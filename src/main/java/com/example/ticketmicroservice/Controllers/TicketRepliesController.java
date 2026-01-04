package com.example.ticketmicroservice.Controllers;

import com.example.ticketmicroservice.Entities.TicketReplies;
import com.example.ticketmicroservice.Services.TicketRepliesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketreplies")
public class TicketRepliesController {
    private final TicketRepliesService ticketRepliesService;

    public TicketRepliesController(TicketRepliesService ticketRepliesService) {
        this.ticketRepliesService = ticketRepliesService;
    }

    @GetMapping
    public List<TicketReplies> getAllTicketReplies() {
        return ticketRepliesService.getAllTicketReplies();
    }

    @GetMapping(path = "{id}")
    public TicketReplies getTicketRepliesById(@PathVariable Long id) {
        return ticketRepliesService.getTicketRepliesById(id);
    }

    @PostMapping("/save")
    public TicketReplies saveTicketReplies(@RequestBody TicketReplies ticketReplies) {
        return ticketRepliesService.saveTicketReplies(ticketReplies);
    }

    @PutMapping("/updateTicketReplies/{id}")
    public TicketReplies updateTicketReplies(@PathVariable Long id, @RequestBody TicketReplies ticketReplies) {
        ticketReplies.setId(id);
        return ticketRepliesService.updateTicketReplies(ticketReplies);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTicketReplies(@PathVariable Long id) {
        ticketRepliesService.deleteTicketReplies(id);
    }
}
