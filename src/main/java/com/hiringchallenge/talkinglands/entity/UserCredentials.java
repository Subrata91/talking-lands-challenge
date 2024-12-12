package com.hiringchallenge.talkinglands.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Document(collection = "user_credentials")
public class UserCredentials {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String password;
}
