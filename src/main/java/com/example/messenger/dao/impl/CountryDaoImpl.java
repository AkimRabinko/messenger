package com.example.messenger.dao.impl;

import com.example.messenger.dao.CountryDao;
import com.example.messenger.model.Country;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.messenger.dao.impl.DaoUtils.isUpdated;

@Repository
@AllArgsConstructor
public class CountryDaoImpl implements CountryDao {
    private static final String SAVE_COUNTRY = "INSERT INTO country (name) VALUES (?);";
    private static final String UPDATE_COUNTRY = "UPDATE country SET name = ? WHERE id = ?;";
    private static final String DELETE_COUNTRY = "DELETE FROM country WHERE id = ?;";
    private static final String GET_COUNTRY = "SELECT * FROM country WHERE id = ?;";
    private static final String GET_COUNTRIES = "SELECT * FROM country;";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean saveCountry(Country country) {
        return isUpdated(jdbcTemplate.update(SAVE_COUNTRY, country.getName()));
    }

    @Override
    public boolean updateCountry(Country country) {
        return isUpdated(jdbcTemplate.update(UPDATE_COUNTRY, country.getName(), country.getId()));
    }

    @Override
    public boolean deleteCountry(int id) {
        return isUpdated(jdbcTemplate.update(DELETE_COUNTRY, id));
    }

    @Override
    public Country getCountry(int id) {
        return jdbcTemplate.queryForObject(GET_COUNTRY, Country.class, id);
    }

    @Override
    public List<Country> getCountries() {
        return jdbcTemplate.query(GET_COUNTRIES, BeanPropertyRowMapper.newInstance(Country.class));
    }
}
