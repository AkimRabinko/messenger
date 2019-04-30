package com.example.messenger.dao.impl;

import com.example.messenger.dao.CityDao;
import com.example.messenger.model.City;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.messenger.dao.impl.DaoUtils.isUpdated;

@Repository
@AllArgsConstructor
public class CityDaoImpl implements CityDao {
    private static final String SAVE_CITY = "INSERT INTO city (name, country_id) VALUES (?, ?);";
    private static final String UPDATE_CITY = "UPDATE city SET name = ?, country_id = ? WHERE id = ?;";
    private static final String DELETE_CITY = "DELETE FROM city WHERE id = ?;";
    private static final String GET_CITY_BY_ID = "SELECT * FROM city WHERE id = ?;";
    private static final String GET_CITY_BY_NAME = "SELECT * FROM city WHERE name= ?;";
    private static final String GET_CITIES_BY_COUNTRY = "SELECT * FROM city WHERE country_id = ?;";
    private static final String GET_CITIES = "SELECT * FROM city;";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean saveCity(City city) {
        return isUpdated(jdbcTemplate.update(SAVE_CITY, city.getName(), city.getCountryId()));
    }

    @Override
    public boolean updateCity(City city) {
        return isUpdated(jdbcTemplate.update(UPDATE_CITY, city.getName(), city.getCountryId(), city.getId()));
    }

    @Override
    public boolean deleteCity(int id) {
        return isUpdated(jdbcTemplate.update(DELETE_CITY, id));
    }

    @Override
    public City getCity(int id) {
        return jdbcTemplate.queryForObject(GET_CITY_BY_ID, City.class, id);
    }

    @Override
    public City getCity(String name) {
        return jdbcTemplate.queryForObject(GET_CITY_BY_NAME, City.class, name);
    }

    @Override
    public List<City> getCities(int country) {
        return jdbcTemplate.query(GET_CITIES_BY_COUNTRY, BeanPropertyRowMapper.newInstance(City.class), country);
    }

    @Override
    public List<City> getCities() {
        return jdbcTemplate.query(GET_CITIES, BeanPropertyRowMapper.newInstance(City.class));
    }
}
