package com.example.messenger.dao;

import com.example.messenger.model.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {
    boolean saveCity(City city);

    boolean updateCity(City city);

    boolean deleteCity(int id);

    Optional<City> getCity(int id);

    Optional<City> getCity(String name);

    List<City> getCities(int country);

    List<City> getCities();
}
