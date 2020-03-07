package com.example.messenger.model;

import com.example.messenger.model.enums.UserRole;
import com.example.messenger.model.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
@JsonDeserialize(builder = User.UserBuilder.class)
public class User {
    int id;
    LocalDate birthday;
    UserStatus status;
    UserRole role;
    String firstName;
    String lastName;
    City city;
    Country country;
    String email;
    String password;
    List<Integer> articles;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserBuilder {
    }
}
