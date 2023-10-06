package com.MovieApp.TicketCounter.repository;

import com.MovieApp.TicketCounter.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
