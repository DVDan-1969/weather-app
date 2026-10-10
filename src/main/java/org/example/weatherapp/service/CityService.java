package org.example.weatherapp.service;

import org.example.weatherapp.model.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> getAllCities();
    Optional<City> getCityByName(String name);
    Optional<City> getCityById(Long id);
    City saveCity(City city);
    void deleteCity(Long id);

}
