package com.hiringchallenge.talkinglands.controller;

import com.hiringchallenge.talkinglands.dto.request.AuthorizationRequest;
import com.hiringchallenge.talkinglands.dto.request.CreateUserRequest;
import com.hiringchallenge.talkinglands.dto.response.AuthorizationResponse;
import com.hiringchallenge.talkinglands.dto.response.CreateUserResponse;
import com.hiringchallenge.talkinglands.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PostMapping("/auth")
    public AuthorizationResponse authenticateUser(@RequestBody AuthorizationRequest request) {
        return userService.authenticateUser(request);
    }
}
