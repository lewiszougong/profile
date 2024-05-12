package com.demo.profile.service;

import com.demo.profile.adaptor.model.GetUserAccountsResponse;
import com.demo.profile.mapper.GetAllUsersMapper;
import com.demo.profile.model.entity.UserEntity;
import com.demo.profile.model.request.GetAllUsersRequest;
import com.demo.profile.model.response.GetAllUsersResponse;
import com.demo.profile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllUsersService {

    private final UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public GetAllUsersResponse execute(GetAllUsersRequest request) {

        var userEntityList = userRepository.findAll(PageRequest.of(request.getPageNo(), request.getPageSize(), Sort.by("userRefId").descending()));
        return GetAllUsersResponse.builder()
                .users(userEntityList.stream()
                        .map(this::buildResponse)
                        .collect(Collectors.toList()))
                .build();
    }

    public GetAllUsersResponse.User buildResponse(UserEntity userEntity) {

        var accounts = restTemplate.getForObject("http://localhost:8081/v1/account/{userRefId}",
                    GetUserAccountsResponse.class, Map.of("userRefId",userEntity.getUserRefId()));


        return GetAllUsersMapper.INSTANCE.fromUserEntity(userEntity, accounts);
    }

}
