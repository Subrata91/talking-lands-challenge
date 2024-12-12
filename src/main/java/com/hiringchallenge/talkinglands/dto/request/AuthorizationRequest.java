package com.hiringchallenge.talkinglands.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequest {
    @NotEmpty(message = "Locale code cannot be empty")
    private String username; // could be email or phone number

    @NotEmpty(message = "Locale code cannot be empty")
    private String password;
}
