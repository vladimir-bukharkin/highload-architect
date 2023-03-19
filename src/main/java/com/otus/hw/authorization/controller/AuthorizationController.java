package com.otus.hw.authorization.controller;

import com.otus.hw.authorization.dto.UserRegistrationDto;
import com.otus.hw.authorization.service.UserRegistrationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/user")
public class AuthorizationController {

    UserRegistrationService userService;

    @PostMapping(path = "/register", produces = "application/json", consumes = "application/json")
    public UserRegistrationDto registerUserAccount(@Valid @RequestBody UserRegistrationDto user) {
        return userService.registerNewUser(user);
    }
}
