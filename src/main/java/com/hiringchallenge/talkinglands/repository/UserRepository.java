package com.hiringchallenge.talkinglands.repository;

import com.hiringchallenge.talkinglands.entity.UserCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserCredentials, String> {
    Optional<UserCredentials> findByEmail(String email);
    Optional<UserCredentials> findByPhoneNumber(String phoneNumber);
}
