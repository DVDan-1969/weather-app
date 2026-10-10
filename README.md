Weather App

Weather App is a web application developed using Java and Spring Boot that allows users to search for current weather information in different cities.
The application retrieves weather data from the Open-Meteo API and displays temperature,humidity and wind speed.
Users can also save their favorite cities,view their saved locations, and remove cities from their favorites list.

#Technologies Used
-Java
-Spring Boot
-Spring Data JPA
-Spring Web MVC
-Thymeleaf
-MySQL
-HTML and CSS
-Maven
-Git and GitHub

#Features
-Search for current weather information by sity name
-Display temperature,humidity and wind speed.
-Save favorite cities in a MySQL database.
-View and delete favorite cities.
-Prevent duplicate favorite cities.
-Handle invalid city searches and weather service connection errors.
-REST API endpoints for weather information and city management.

Installation and Setup

#Prerequisites

Before running the application,make sure you have installed:
-Java 17 or later.
-MySQL Server
-Git
-IntelliJ IDEA or another Java IDE

#Database Configuration

1.Create a MySQL database named weather_db.
2.Copy src/main/resources/application.properties.example to src/main/resources/application.properties.
3.Update the database username and password in application.properties with your local MySQL credentials.

Running the Application

1.Clone the repository:
git clone http://github.com/DVDan-1969/weather-app.git.
2.Open the project in IntelliJ IDEA.
3.Make sure MySQL Server is running.
4.Run the WeatherApplication class.
5.Open your browser and navigate to:http://localhost:8080

Weather Data Source

Weather information is retrieved from the Open-Meteo API.
Website:https://open-meteo.com
