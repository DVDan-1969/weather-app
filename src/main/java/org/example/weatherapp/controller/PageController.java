package org.example.weatherapp.controller;

import org.example.weatherapp.dto.WeatherData;
import org.example.weatherapp.model.City;
import org.example.weatherapp.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.example.weatherapp.service.WeatherService;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.ResourceAccessException;

@Controller
public class PageController {
    private final CityService cityService;
    private final WeatherService weatherService;

    public PageController(CityService cityService, WeatherService weatherService) {
        this.cityService = cityService;
        this.weatherService= weatherService;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String cityName, Model model) {
        if (cityName != null) {
            cityName = cityName.trim();
        }
        if (cityName != null && !cityName.isBlank()) {
            try {
                WeatherData weatherData = weatherService.getWeatherByCity(cityName);
                model.addAttribute("weather", weatherData);
                model.addAttribute("cityName", cityName);
            }catch (ResponseStatusException e) {

                if (e.getStatusCode().value() == 404) {
                    model.addAttribute(
                            "error",
                            "City not found. Please enter a valid city name."
                    );
                } else {
                    model.addAttribute(
                            "error",
                            "Unable to retrieve weather information."
                    );
                }
            }catch (ResourceAccessException e) {
                model.addAttribute(
                        "error",
                        "Weather service is temporarily unavailable. Please try again later."
                );
            }
        }
        return "index";
    }
    @GetMapping("/favorites")
    public String favorites(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        return "favorites";
    }
    @PostMapping("/favorites/add")
    public String addFavorite(@RequestParam String cityName) {
        cityName=cityName.trim();
        WeatherData weatherData = weatherService.getWeatherByCity(cityName);

        City city = new City(
                cityName,
                weatherData.getLatitude(),
                weatherData.getLongitude()
        );
        if (cityService.getCityByName(cityName).isEmpty()) {
            cityService.saveCity(city);
        }

        return "redirect:/favorites";
    }
    @PostMapping("/favorites/delete/{id}")
    public String deleteFavorite(@PathVariable Long id) {

        cityService.deleteCity(id);

        return "redirect:/favorites";
    }
}
