package org.example.weatherapp.repository;

import org.example.weatherapp.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long> {
    Optional<City> findByNameIgnoreCase(String name);
}
