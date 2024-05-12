package com.demo.profile.controller;

import com.demo.profile.model.request.CreateUserRequest;
import com.demo.profile.model.request.GetAllUsersRequest;
import com.demo.profile.model.response.CreateUserResponse;
import com.demo.profile.model.response.GetAllUsersResponse;
import com.demo.profile.service.CreateUserService;
import com.demo.profile.service.GetAllUsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/profile")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final GetAllUsersService getAllUsersService;
    private final CreateUserService createUserService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetAllUsersResponse retrieveAccounts(
            @RequestBody GetAllUsersRequest request
    ) {
        return getAllUsersService.execute(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreateUserResponse createAccount(
            @RequestBody CreateUserRequest request
    ) throws Exception {
        return createUserService.execute(request);
    }
}
