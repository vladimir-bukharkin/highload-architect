package com.otus.hw.authorization.controller;

import com.otus.hw.authorization.dto.UserRegistrationDto;
import com.otus.hw.authorization.exception.UserAlreadyExistsException;
import com.otus.hw.authorization.service.UserRegistrationService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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

    @ControllerAdvice
    public static class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler({ UserAlreadyExistsException.class })
        public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
            return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.FORBIDDEN);}
    }
}
