package com.example.messenger.dao;

import com.example.messenger.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryDao {
    boolean saveCountry(Country country);

    boolean updateCountry(Country country);

    boolean deleteCountry(int id);

    Optional<Country> getCountry(int id);

    List<Country> getCountries();
}
