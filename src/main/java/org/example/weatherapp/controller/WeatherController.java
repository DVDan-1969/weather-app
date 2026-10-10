package org.example.weatherapp.controller;

import org.example.weatherapp.dto.WeatherData;
import org.example.weatherapp.service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    public WeatherData getWeather(@PathVariable String cityName) {
        return weatherService.getWeatherByCity(cityName);
    }
}
