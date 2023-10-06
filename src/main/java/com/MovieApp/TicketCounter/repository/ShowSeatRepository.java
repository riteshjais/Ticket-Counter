package com.MovieApp.TicketCounter.repository;

import com.MovieApp.TicketCounter.model.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity, Integer> {
}
