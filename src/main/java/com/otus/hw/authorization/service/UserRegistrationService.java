package com.otus.hw.authorization.service;

import com.otus.hw.authorization.dto.UserRegistrationDto;
import com.otus.hw.authorization.mapper.UserRegistrationMapper;
import com.otus.hw.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationService {

    UserRepository userRepository;
    UserRegistrationMapper mapper;

    public UserRegistrationDto registerNewUser(UserRegistrationDto userDto) {
        userRepository.save(mapper.map(userDto));
        return userDto;
    }
}
