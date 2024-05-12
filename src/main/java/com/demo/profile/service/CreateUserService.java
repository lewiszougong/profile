package com.demo.profile.service;

import com.demo.profile.mapper.CreateUserMapper;
import com.demo.profile.model.request.CreateUserRequest;
import com.demo.profile.model.response.CreateUserResponse;
import com.demo.profile.repository.UserPreferenceRepository;
import com.demo.profile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUserService {

    private final UserRepository userRepository;
    private final UserPreferenceRepository userPreferenceRepository;


    @Transactional(rollbackFor = Exception.class)
    public CreateUserResponse execute(CreateUserRequest request) throws Exception {
        log.info("request for createUser: " + request);
        userRepository.save(
                CreateUserMapper.INSTANCE.fromCreateUserRequest(request, "pending", ZonedDateTime.now()));

        //implement:some business logic to trigger error for rollback
        if (request.getUserRefId().length()>1) {
            throw new Exception();
        }

        userPreferenceRepository.save(
                CreateUserMapper.INSTANCE.fromCreateUserPreference(request));

        var createUserResponse =  CreateUserResponse.builder()
                .status("success")
                .build();

        log.info("response for createUser: " + createUserResponse);

        return createUserResponse;
    }
}
