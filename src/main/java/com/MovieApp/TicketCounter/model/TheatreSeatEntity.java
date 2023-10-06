package com.MovieApp.TicketCounter.model;

import com.MovieApp.TicketCounter.model.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater_seats")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class TheatreSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_seat_id")
    private long theatreSeatId;

    @Column(name = "seat_number", nullable = false)
    private String theatreSeatNumber;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "theatre_id",  referencedColumnName= "theatre_id")
    private TheatreEntity theatreEntity;


}
