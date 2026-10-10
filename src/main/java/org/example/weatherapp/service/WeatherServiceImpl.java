package org.example.weatherapp.service;

import org.example.weatherapp.dto.WeatherData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public WeatherData getWeatherByCity(String cityName) {
        RestClient client=RestClient.create();
        String response=client.get()
                .uri("https://geocoding-api.open-meteo.com/v1/search?name={name}&count=1",cityName)
                .retrieve()
                .body(String.class);
        System.out.println(response);
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(response);
        JsonNode results = root.get("results");
        if (results == null || results.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"City not found: "+cityName);
        }
        JsonNode city = results.get(0);

        double latitude = city.get("latitude").asDouble();
        double longitude = city.get("longitude").asDouble();

        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);
        String weatherResponse = client.get()
                .uri("https://api.open-meteo.com/v1/forecast"
                                + "?latitude={lat}&longitude={lon}"
                                + "&current=temperature_2m,relative_humidity_2m,wind_speed_10m",
                        latitude, longitude)
                .retrieve()
                .body(String.class);

        System.out.println(weatherResponse);
        JsonNode weatherRoot = mapper.readTree(weatherResponse);

        JsonNode current = weatherRoot.get("current");

        double temperature = current.get("temperature_2m").asDouble();
        double humidity = current.get("relative_humidity_2m").asDouble();
        double windSpeed = current.get("wind_speed_10m").asDouble();



        return new WeatherData(temperature, humidity, windSpeed, latitude, longitude);
    }
}
