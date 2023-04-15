package com.otus.hw.authorization.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/")
public class CommonController {

    @GetMapping(path = "/")
    public String registerUserAccount() {
        return "Авторизация прошла успешно";
    }

    @PostMapping(path = "/df")
    public String df(@RequestBody String str) {
        log.info("Пришло сообщение: [{}]", str);
        return "ok";
    }
}
