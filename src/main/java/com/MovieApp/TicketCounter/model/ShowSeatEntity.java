package com.MovieApp.TicketCounter.model;

import com.MovieApp.TicketCounter.model.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "show_seats")
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_seat_id")
    private long showSeatId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @Column(name = "is_booked")
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    private Date bookedAt;

    @ManyToOne
    @JoinColumn(name = "movie_show_id", referencedColumnName = "movie_show_id")
    private MovieShowEntity movieShowEntity;

//    @ManyToOne
//    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
//    private TicketEntity ticketEntity;




//    @ManyToOne
//    @JsonIgnore
//    private MovieShowEntity show;
//
//    @ManyToOne
//    @JsonIgnore
//    private TicketEntity ticket;
}
