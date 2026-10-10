package org.example.weatherapp.dto;

public class WeatherData {
    private double temperature;
    private double humidity;
    private double windSpeed;
    private double latitude;
    private double longitude;

    public WeatherData(){}

    public WeatherData(double temperature, double humidity, double windSpeed, double latitude, double longitude) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getTemperature() {return temperature;}
    public void setTemperature(double temperature) {this.temperature = temperature;}
    public double getHumidity() {return humidity;}
    public void setHumidity(double humidity) {this.humidity = humidity;}
    public double getWindSpeed() {return windSpeed;}
    public void setWindSpeed(double windSpeed) {this.windSpeed = windSpeed;}
    public double getLatitude() {return latitude;}
    public void setLatitude(double latitude) {this.latitude = latitude;}
    public double getLongitude() {return longitude;}
    public void setLongitude(double longitude) {this.longitude = longitude;}
}
