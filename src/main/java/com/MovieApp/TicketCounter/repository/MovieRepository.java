package com.MovieApp.TicketCounter.repository;

import com.MovieApp.TicketCounter.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}
