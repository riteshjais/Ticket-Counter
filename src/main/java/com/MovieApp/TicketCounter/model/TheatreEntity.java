package com.MovieApp.TicketCounter.model;

import com.MovieApp.TicketCounter.model.enums.TheatreType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "theatre")
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_id")
    private int theatreId;

    @Column(name = "name", nullable = false)
    private String theatreName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TheatreType theatreType;


    @Column(name = "address", nullable = false)
    private String theatreAddress;

    @OneToOne
    @JoinColumn(name = "city_id",referencedColumnName = "city_id")
    private CityEntity cityEntity;

//    @OneToMany
//    @JoinColumn(name = "movie_show_id", referencedColumnName = "movie_show_id")
//    @JsonIgnore
//    private List<MovieShowEntity> shows = new ArrayList<>();
//
//    @OneToMany
//    @JoinColumn(name = "theatre_seat_id", referencedColumnName = "theatre_seat_id")
//    @JsonIgnore
//    private List<TheatreSeatEntity> seats = new ArrayList<>();
//
//    @ManyToOne
//    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
//    private CityEntity cityEntity;
}
