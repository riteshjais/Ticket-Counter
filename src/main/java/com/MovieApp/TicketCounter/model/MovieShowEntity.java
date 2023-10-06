package com.MovieApp.TicketCounter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "movie_show")
public class MovieShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_show_id")
    private long movieShowId;

    @Column(name = "show_date", columnDefinition = "DATE", nullable = false)
    private LocalDate showDate;

    @Column(name = "show_time", columnDefinition = "TIME", nullable = false)
    private LocalTime showTime;

    @Column(name = "rate_multiplier", columnDefinition = "float(2,1) default 1.0", nullable = false)
    private float rateMultiplier;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updatedAt;


    @ManyToOne
    @JoinColumn(name = "movie_id",referencedColumnName = "movie_id")
    private MovieEntity movieEntity;

    @ManyToOne
    @JoinColumn(name = "theatre_id", referencedColumnName = "theatre_id")
    private TheatreEntity theatreEntity;











////    @ManyToOne
////    @JsonIgnore
////    private MovieEntity movie;
//
////    @ManyToOne
//    @OneToOne
//    @JoinColumn(name = "theatre_id", referencedColumnName = "theatre_id")
//    @JsonIgnore
//    private TheatreEntity theater;
//
////    @OneToMany
////    @JsonIgnore
////    private List<TicketEntity> tickets;
//
////    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
////    @JsonIgnore
////    private List<ShowSeatEntity> seats;


}
