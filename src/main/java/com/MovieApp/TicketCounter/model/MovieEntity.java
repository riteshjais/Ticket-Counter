package com.MovieApp.TicketCounter.model;

import com.MovieApp.TicketCounter.model.enums.Certification_Type;
import com.MovieApp.TicketCounter.model.enums.MovieLanguage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_description")
    private String movieDescription;
    @Column(name = "movie_language")
    private MovieLanguage movieLanguage;
    @Column(name = "certificate_type")
    private Certification_Type certificationType;
    @Column(name = "release_date")
    private LocalDate releaseDate;

//    @OneToMany
//    @JoinColumn(name = "movie_show_id",referencedColumnName = "movie_show_id")
//    private List<MovieShowEntity> movieShow;

//    @OneToOne
//    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
//    private CityEntity cityEntity;

}
