package com.MovieApp.TicketCounter.dto.respond;

import com.MovieApp.TicketCounter.model.enums.Certification_Type;
import com.MovieApp.TicketCounter.model.enums.MovieLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieRespondDTO {
    private int movieId;
    private String movieName;
    private String movieDescription;
    private MovieLanguage movieLanguage;
    private Certification_Type certificationType;
    private LocalDate releaseDate;
}
