package com.example.messenger.service;

import com.example.messenger.model.Country;

import java.util.List;

public interface CountryService {
    boolean saveCountry(Country country);

    boolean updateCountry(Country country);

    boolean deleteCountry(int id);

    Country getCountry(int id);

    List<Country> getCountries();
}
