package com.example.messenger.controller;

import com.example.messenger.model.Country;
import com.example.messenger.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("country")
public class CountryController {
    private final CountryService countryService;

    @PostMapping
    public boolean saveCountry(Country country) {
        return countryService.saveCountry(country);
    }

    @PutMapping
    public boolean updateCountry(Country country) {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("{id}")
    public boolean deleteCountry(@PathVariable int id) {
        return countryService.deleteCountry(id);
    }

    @GetMapping("{id}")
    public Country getCountry(@PathVariable int id) {
        return countryService.getCountry(id);
    }

    @GetMapping("all")
    public List<Country> getCountries() {
        return countryService.getCountries();
    }
}
