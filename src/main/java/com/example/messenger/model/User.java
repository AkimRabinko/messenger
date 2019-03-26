package com.example.messenger.model;

import com.example.messenger.model.enums.UserRole;
import com.example.messenger.model.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class User {
    private int id;
    private Date birthday;
    private UserStatus status;
    private UserRole role;
    private String firstName;
    private String lastName;
    private City city;
    private Country country;
    private String email;
    private String password;
    private List<Integer> articles;
}
