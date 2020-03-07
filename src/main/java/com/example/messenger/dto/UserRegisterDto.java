package com.example.messenger.dto;

import com.example.messenger.model.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;


@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = UserRegisterDto.UserRegisterDtoBuilder.class)
public class UserRegisterDto {
    LocalDate birthday;
    String firstName;
    String lastName;
    int cityId;
    int countryId;
    String email;
    String password;
    UserRole role;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserRegisterDtoBuilder {
    }
}
