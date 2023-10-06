package com.MovieApp.TicketCounter.repository;

import com.MovieApp.TicketCounter.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    @Query("SELECT t FROM Token t " +
            "INNER JOIN t.user u " +
            "WHERE u.userId = :id AND t.expired=false")
    List<Token> findAllValidTokenByUser(Integer id);
    Optional<Token> findByToken(String token);

}
