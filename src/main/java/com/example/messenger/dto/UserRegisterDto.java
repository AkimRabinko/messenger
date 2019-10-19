package com.example.messenger.dto;

import com.example.messenger.model.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class UserRegisterDto {
    private LocalDate birthday;
    private String firstName;
    private String lastName;
    private int cityId;
    private int countryId;
    private String email;
    private String password;
    private UserRole role;
}
