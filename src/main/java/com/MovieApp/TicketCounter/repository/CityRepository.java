package com.MovieApp.TicketCounter.repository;

import com.MovieApp.TicketCounter.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    Boolean existsByCityName(String cityName);

    Optional<CityEntity> findByCityName(String cityName);
}
