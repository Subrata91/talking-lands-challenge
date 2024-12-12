package com.hiringchallenge.talkinglands.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponse {
    private String username;
    private boolean isAuthenticated;
}
