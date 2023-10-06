package com.MovieApp.TicketCounter.repository;

import com.MovieApp.TicketCounter.model.MovieShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieShowRepository extends JpaRepository<MovieShowEntity, Integer> {
}
