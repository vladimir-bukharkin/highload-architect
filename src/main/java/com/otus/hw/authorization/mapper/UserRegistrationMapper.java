package com.otus.hw.authorization.mapper;

import com.otus.hw.authorization.dto.UserRegistrationDto;
import com.otus.hw.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRegistrationMapper {

    @Mapping(target = "id", expression  = "java(java.util.UUID.randomUUID())")
    User map(UserRegistrationDto source);

    UserRegistrationDto map(User destination);
}
