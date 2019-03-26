package com.example.messenger.dto;

import com.example.messenger.model.City;
import com.example.messenger.model.Country;
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
    private City city;
    private Country country;
    private String email;
    private String password;
    private UserRole role;
}
