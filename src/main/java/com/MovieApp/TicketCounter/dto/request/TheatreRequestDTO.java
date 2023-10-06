package com.MovieApp.TicketCounter.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TheatreRequestDTO {
    private String theatreName;
    private String theatreType;
    private String theatreAddress;
    private String cityName;
}
