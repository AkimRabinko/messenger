package com.example.messenger.service.impl;

import com.example.messenger.dao.CityDao;
import com.example.messenger.model.City;
import com.example.messenger.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityDao cityDao;

    @Override
    public boolean saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public boolean updateCity(City city) {
        return cityDao.updateCity(city);
    }

    @Override
    public boolean deleteCity(int id) {
        return cityDao.deleteCity(id);
    }

    @Override
    public City getCity(int id) {
        return cityDao.getCity(id)
                .orElseThrow();
    }

    @Override
    public City getCity(String name) {
        return cityDao.getCity(name)
                .orElseThrow();
    }

    @Override
    public List<City> getCities(int country) {
        return cityDao.getCities(country);
    }

    @Override
    public List<City> getCities() {
        return cityDao.getCities();
    }
}
