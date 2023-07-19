package com.otus.hw.user.controller;

import com.otus.hw.user.dto.UserDto;
import com.otus.hw.user.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/user")
public class UserController {

    UserService userService;

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public UserDto getUser(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/search/", produces = "application/json")
    public UserDto getUser(@RequestParam("first_name") String firstName, @RequestParam("second_name") String secondName) {
        return userService.findByFirstNameAndSecondName(firstName, secondName);
    }
}
