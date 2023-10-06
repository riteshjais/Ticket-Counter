package com.MovieApp.TicketCounter.dto.respond;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRespondDTO {
    private int userId;
    private String name;
    private String email;

}
