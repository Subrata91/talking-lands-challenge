package com.hiringchallenge.talkinglands.service;

import com.hiringchallenge.talkinglands.dto.request.AuthorizationRequest;
import com.hiringchallenge.talkinglands.dto.request.CreateUserRequest;
import com.hiringchallenge.talkinglands.dto.response.AuthorizationResponse;
import com.hiringchallenge.talkinglands.dto.response.CreateUserResponse;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest request);
    AuthorizationResponse authenticateUser(AuthorizationRequest request);
}
