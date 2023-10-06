package com.MovieApp.TicketCounter.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TheatreRespondDTO {
    private int theatreId;
    private String theatreName;
    private String theatreType;
    private String theatreAddress;
    private String cityName;
}
