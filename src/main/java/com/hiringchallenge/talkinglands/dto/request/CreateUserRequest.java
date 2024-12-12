package com.hiringchallenge.talkinglands.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dob;
    private String password;
}
