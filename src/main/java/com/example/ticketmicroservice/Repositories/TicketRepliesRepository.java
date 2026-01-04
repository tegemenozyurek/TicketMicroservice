package com.example.ticketmicroservice.Repositories;

import com.example.ticketmicroservice.Entities.TicketReplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepliesRepository extends JpaRepository<TicketReplies, Long> {
}
