package com.otus.hw.authorization.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRegistrationDto {

    @NotNull
    @NotEmpty
    @JsonProperty("first_name")
    String firstName;

    @NotNull
    @NotEmpty
    @JsonProperty("second_name")
    String secondName;

    @NotNull
    LocalDate birthday;

    String biography;

    @NotNull
    @NotEmpty
    String city;

    @NotNull
    @NotEmpty
    String password;
}
