package com.MovieApp.TicketCounter.dto.request;

import com.MovieApp.TicketCounter.model.enums.Certification_Type;
import com.MovieApp.TicketCounter.model.enums.MovieLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.cert.Certificate;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieRequestDTO {
    private String movieName;
    private String movieDescription;
    private MovieLanguage movieLanguage;
    private Certification_Type certificationType;
    private LocalDate releaseDate;
}
