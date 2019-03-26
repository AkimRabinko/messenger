package com.example.messenger.dao.impl;

import com.example.messenger.dao.UserDao;
import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;
import com.example.messenger.model.enums.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@AllArgsConstructor
public class UserDaoImpl implements UserDao {
    private static final String SAVE_USER = "INSERT INTO public.user " +
            "(birthday, first_name, last_name, city, country, email, password) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id;";
    private static final String SAVE_ROLE = "INSERT INTO public.user_roles (user_id, role) VALUES (?, ?);";
    private static final String UPDATE_USER = "UPDATE public.user SET " +
            "birthday = ?, first_name = ?, last_name = ?, city = ?, country = ? WHERE id = ?;";
    private static final String GET_USER = "SELECT * FROM public.user WHERE id = ?;";
    private static final String DELETE_USER = "DELETE FROM public.user WHERE id = ?;";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int saveUser(UserRegisterDto user) {
        return Optional.ofNullable(
                jdbcTemplate.queryForObject(SAVE_USER, Integer.class,
                        user.getBirthday(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getCity().getId(),
                        user.getCountry().getId(),
                        user.getEmail(),
                        user.getPassword()))
                .orElse(-1);
    }

    @Override
    public boolean saveRole(int userId, UserRole role) {
        return jdbcTemplate.update(SAVE_ROLE, userId, role.name()) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return jdbcTemplate.update(UPDATE_USER,
                user.getBirthday(),
                user.getFirstName(),
                user.getLastName(),
                user.getCity().getId(),
                user.getCountry().getId(),
                user.getId()) > 0;
    }

    @Override
    public User getUser(int id) {
        return jdbcTemplate.queryForObject(GET_USER, User.class, id);
    }

    @Override
    public boolean deleteUser(int id) {
        return jdbcTemplate.update(DELETE_USER, id) > 0;
    }
}
