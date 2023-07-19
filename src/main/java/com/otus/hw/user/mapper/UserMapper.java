package com.otus.hw.user.mapper;

import com.otus.hw.user.dto.UserDto;
import com.otus.hw.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", expression  = "java(java.util.UUID.randomUUID())")
    User map(UserDto source);

    UserDto map(User destination);
}
