package com.example.messenger.service.impl;

import com.example.messenger.dao.CountryDao;
import com.example.messenger.model.Country;
import com.example.messenger.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryDao countryDao;

    @Override
    public boolean saveCountry(Country country) {
        return countryDao.saveCountry(country);
    }

    @Override
    public boolean updateCountry(Country country) {
        return countryDao.updateCountry(country);
    }

    @Override
    public boolean deleteCountry(int id) {
        return countryDao.deleteCountry(id);
    }

    @Override
    public Country getCountry(int id) {
        return countryDao.getCountry(id)
                .orElseThrow();
    }

    @Override
    public List<Country> getCountries() {
        return countryDao.getCountries();
    }
}
