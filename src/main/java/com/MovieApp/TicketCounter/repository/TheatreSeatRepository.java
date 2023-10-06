package com.MovieApp.TicketCounter.repository;

import com.MovieApp.TicketCounter.model.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity,Integer> {
}
