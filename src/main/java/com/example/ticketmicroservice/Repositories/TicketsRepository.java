package com.example.ticketmicroservice.Repositories;

import com.example.ticketmicroservice.Entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    
}
