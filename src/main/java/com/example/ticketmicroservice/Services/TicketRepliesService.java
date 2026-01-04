package com.example.ticketmicroservice.Services;

import com.example.ticketmicroservice.Entities.TicketReplies;
import com.example.ticketmicroservice.Repositories.TicketRepliesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketRepliesService {
    private final TicketRepliesRepository ticketRepliesRepository;

    public TicketRepliesService(TicketRepliesRepository ticketRepliesRepository) {
        this.ticketRepliesRepository = ticketRepliesRepository;
    }

    public List<TicketReplies> getAllTicketReplies() {
        return ticketRepliesRepository.findAll();
    }

    public TicketReplies getTicketRepliesById(Long id) {
        return ticketRepliesRepository.findById(id).orElse(null);
    }

    public TicketReplies saveTicketReplies(TicketReplies ticketReplies) {
        return ticketRepliesRepository.save(ticketReplies);
    }

    public TicketReplies updateTicketReplies(TicketReplies ticketReplies) {
        TicketReplies existing = ticketRepliesRepository.findById(ticketReplies.getId()).orElse(null);

        if (ticketReplies.getTicketId() != null) existing.setTicketId(ticketReplies.getTicketId());
        if (ticketReplies.getAuthorId() != null) existing.setAuthorId(ticketReplies.getAuthorId());
        if (ticketReplies.getMessage() != null) existing.setMessage(ticketReplies.getMessage());
        if (ticketReplies.getCreated_at() != null) existing.setCreated_at(ticketReplies.getCreated_at());

        return ticketRepliesRepository.save(existing);
    }

    public void deleteTicketReplies(Long id) {
        ticketRepliesRepository.deleteById(id);
    }
}
