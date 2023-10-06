package com.MovieApp.TicketCounter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private long ticketId;

    @Column(name = "allotted_seats")
    private String allottedSeats;

    @Column(name = "amount", nullable = false)
    private double amount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at", nullable = false)
    private Date bookedAt;

//    @ManyToOne
//    @JoinColumn(name = "movie_show_id", referencedColumnName = "movie_show_id")
//    @JsonIgnore
//    private MovieShowEntity show;
//
//    @OneToMany(mappedBy = "ticketEntity")
//    private List<ShowSeatEntity> showSeatEntities;

    @OneToOne
    @JoinColumn(name = "movie_show_id", referencedColumnName = "movie_show_id")
    private MovieShowEntity movieShowEntity;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;



//    @OneToMany(mappedBy = "show_seats", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<ShowSeatEntity> seats;
}
