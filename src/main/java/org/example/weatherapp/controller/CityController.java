package org.example.weatherapp.controller;


import org.example.weatherapp.model.City;
import org.example.weatherapp.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService service;
    public CityController(CityService service) {
        this.service = service;
    }
    @GetMapping
    public List<City> getAllCities() {
        return service.getAllCities();
    }


    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City createdCity = service.saveCity(city);
        return ResponseEntity.ok(createdCity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCity(id);
        return ResponseEntity.noContent().build();
    }

}
