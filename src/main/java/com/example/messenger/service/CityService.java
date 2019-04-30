package com.example.messenger.service;

import com.example.messenger.model.City;

import java.util.List;

public interface CityService {
    boolean saveCity(City city);

    boolean updateCity(City city);

    boolean deleteCity(int id);

    City getCity(int id);

    City getCity(String name);

    List<City> getCities(int country);

    List<City> getCities();
}
