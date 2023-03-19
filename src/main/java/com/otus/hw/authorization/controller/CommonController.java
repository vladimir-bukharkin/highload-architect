package com.otus.hw.authorization.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/")
public class CommonController {

    @GetMapping(path = "/")
    public String registerUserAccount() {
        return "Авторизация прошла успешно";
    }
}
