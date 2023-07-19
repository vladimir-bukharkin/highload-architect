package com.otus.hw.user.service;

import com.otus.hw.user.dto.UserDto;
import com.otus.hw.user.mapper.UserMapper;
import com.otus.hw.user.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;
    UserMapper mapper;

    public UserDto findById(UUID id) {
        return mapper.map(userRepository.findById(id));
    }

    public UserDto findByFirstNameAndSecondName(String firstName, String secondName) {
        return mapper.map(userRepository.findByFirstNameAndSecondName(firstName, secondName));
    }
}
