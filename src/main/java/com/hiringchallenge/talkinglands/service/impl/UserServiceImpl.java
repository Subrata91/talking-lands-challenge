package com.hiringchallenge.talkinglands.service.impl;

import com.hiringchallenge.talkinglands.dto.request.AuthorizationRequest;
import com.hiringchallenge.talkinglands.dto.request.CreateUserRequest;
import com.hiringchallenge.talkinglands.dto.response.AuthorizationResponse;
import com.hiringchallenge.talkinglands.dto.response.CreateUserResponse;
import com.hiringchallenge.talkinglands.entity.UserCredentials;
import com.hiringchallenge.talkinglands.repository.UserRepository;
import com.hiringchallenge.talkinglands.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest request) {
        // Check if user already exists by email or phone number
        if (userRepository.findByEmail(request.getEmail()).isPresent() ||
                userRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent()) {
            throw new IllegalArgumentException("User with this email or phone number already exists");
        }

        // Encode password using Base64
        String encodedPassword = Base64.getEncoder().encodeToString(
                request.getPassword().getBytes(StandardCharsets.UTF_8)
        );

        UserCredentials user = new UserCredentials();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setDateOfBirth(request.getDob());
        user.setPassword(encodedPassword);

        UserCredentials savedUser = userRepository.save(user);

        CreateUserResponse response = new CreateUserResponse();
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setPhoneNumber(savedUser.getPhoneNumber());
        response.setDateOfBirth(savedUser.getDateOfBirth().toString());
        response.setSignedUp(true);

        return new CreateUserResponse();
    }

    @Override
    public AuthorizationResponse authenticateUser(AuthorizationRequest request) {
        Optional<UserCredentials> userOpt;
        // username can be an email or phone
        if (request.getUsername().contains("@")) {
            // Assume it's an email
            userOpt = userRepository.findByEmail(request.getUsername());
        } else {
            // Assume it's a phone number
            userOpt = userRepository.findByPhoneNumber(request.getUsername());
        }

        AuthorizationResponse response = new AuthorizationResponse();
        response.setUsername(request.getUsername());

        if (userOpt.isPresent()) {
            UserCredentials user = userOpt.get();
            // Decode stored password
            String decodedStoredPassword = new String(
                    Base64.getDecoder().decode(user.getPassword()), StandardCharsets.UTF_8
            );

            response.setAuthenticated(decodedStoredPassword.equals(request.getPassword()));
        } else {
            response.setAuthenticated(false);
        }

        return new AuthorizationResponse();
    }
}
