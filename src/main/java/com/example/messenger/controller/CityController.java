package com.example.messenger.controller;

import com.example.messenger.model.City;
import com.example.messenger.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("city")
public class CityController {
    private final CityService cityService;

    @PostMapping
    public boolean saveCity(City city) {
        return cityService.saveCity(city);
    }

    @PutMapping
    public boolean updateCity(City city) {
        return cityService.updateCity(city);
    }

    @DeleteMapping("{id}/delete")
    public boolean deleteCity(@PathVariable int id) {
        return cityService.deleteCity(id);
    }

    @GetMapping("{id}")
    public City getCity(@PathVariable int id) {
        return cityService.getCity(id);
    }

    @GetMapping("{name}")
    public City getCity(@PathVariable String name) {
        return cityService.getCity(name);
    }

    @GetMapping("country")
    public List<City> getCities(int country) {
        return cityService.getCities(country);
    }

    @GetMapping("all")
    public List<City> getCities() {
        return cityService.getCities();
    }
}
