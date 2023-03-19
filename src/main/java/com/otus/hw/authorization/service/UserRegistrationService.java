package com.otus.hw.authorization.service;

import com.otus.hw.authorization.dto.UserRegistrationDto;
import com.otus.hw.authorization.exception.UserAlreadyExistsException;
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
        checkUniqueUser(userDto);
        var user = mapper.map(userDto);
        userRepository.save(user);
        return mapper.map(user);
    }

    private void checkUniqueUser(UserRegistrationDto userDto) {
        var user = userRepository.findByFirstNameAndSecondName(userDto.getFirstName(), userDto.getSecondName());
        if (user != null) {
            throw new UserAlreadyExistsException("Пользователь уже существует: " + userDto);
        }
    }
}
