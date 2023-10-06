package com.MovieApp.TicketCounter.Auth;

import com.MovieApp.TicketCounter.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private Role role;
    private String email;
    private String password;
}