package org.example.weatherapp.service;

import jakarta.transaction.Transactional;
import org.example.weatherapp.model.City;
import org.example.weatherapp.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;

    }

    @Override
    public List<City> getAllCities() {
        return repository.findAll();
    }

    @Override
    public Optional<City> getCityById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<City> getCityByName(String name) {return repository.findByNameIgnoreCase(name);}

    @Override
    public City saveCity(City city) {
        return repository.save(city);
    }


    @Override
    public void deleteCity(Long id) {
        repository.deleteById(id);
    }

}
