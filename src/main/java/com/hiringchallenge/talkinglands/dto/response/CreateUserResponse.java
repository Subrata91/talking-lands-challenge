package com.hiringchallenge.talkinglands.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private String name;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private boolean isSignedUp;
}
