package com.MovieApp.TicketCounter.repository;

import com.MovieApp.TicketCounter.model.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Integer> {
}
