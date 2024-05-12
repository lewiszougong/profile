package com.demo.profile.mapper;

import com.demo.profile.model.entity.UserEntity;
import com.demo.profile.model.entity.UserPreferenceEntity;
import com.demo.profile.model.request.CreateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.ZonedDateTime;

@Mapper
public abstract class CreateUserMapper {

    public static CreateUserMapper INSTANCE = Mappers.getMapper(CreateUserMapper.class);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "createdDate", source = "createdDate")
    public abstract UserEntity fromCreateUserRequest(
            CreateUserRequest createUserRequest, String status, ZonedDateTime createdDate);

    @Mapping(target = "balanceShown", source = "createUserRequest.userPreference.balanceShown")
    @Mapping(target = "marketingConsent", source = "createUserRequest.userPreference.marketingConsent")
    @Mapping(target = "security", source = "createUserRequest.userPreference.security")
    @Mapping(target = "location", source = "createUserRequest.userPreference.location")
    public abstract UserPreferenceEntity fromCreateUserPreference(CreateUserRequest createUserRequest);
}
