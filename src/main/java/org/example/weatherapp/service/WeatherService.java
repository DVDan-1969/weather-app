package org.example.weatherapp.service;

import org.example.weatherapp.dto.WeatherData;

public interface WeatherService {
    WeatherData getWeatherByCity(String cityName);
}
