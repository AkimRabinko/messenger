package com.example.messenger.dto;

import com.example.messenger.model.City;
import com.example.messenger.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    private int age;
    private String firstName;
    private String lastName;
    private City city;
    private Country country;
    private String email;
    private String password;
}
