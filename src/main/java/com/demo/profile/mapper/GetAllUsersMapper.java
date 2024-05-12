package com.demo.profile.mapper;

import com.demo.profile.adaptor.model.GetUserAccountsResponse;
import com.demo.profile.model.entity.UserEntity;
import com.demo.profile.model.response.GetAllUsersResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class GetAllUsersMapper {

    public static GetAllUsersMapper INSTANCE = Mappers.getMapper(GetAllUsersMapper.class);


    @Mapping(target = "accounts", source = "getUserAccountsResponse.accounts")
    public abstract GetAllUsersResponse.User fromUserEntity(UserEntity userEntity, GetUserAccountsResponse getUserAccountsResponse);
}
