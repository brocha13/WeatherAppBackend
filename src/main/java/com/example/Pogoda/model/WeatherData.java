package com.example.Pogoda.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter()
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "weatherData")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String weather;
    private double temp;
    private int pressure;
    private int humidity;
    private double tempMax;
    private double tempMin;
    private double windSpeed;
    private String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH"));


    public static final class Builder {
        WeatherData instance = new WeatherData();

        public Builder withWeather(String weather) {
            instance.weather = weather;
            return this;
        }

        public Builder withTemp(double temp) {
            instance.temp = temp;
            return this;
        }

        public Builder withPressure(int pressure) {
            instance.pressure = pressure;
            return this;
        }

        public Builder withHumidity(int humidity) {
            instance.humidity = humidity;
            return this;
        }

        public Builder withTempMax(double tempMax) {
            instance.tempMax = tempMax;
            return this;
        }

        public Builder withTempMin(double tempMin) {
            instance.tempMin = tempMin;
            return this;
        }

        public Builder withWindSpeed(double windSpeed) {
            instance.windSpeed = windSpeed;
            return this;
        }

        public Builder withDateTime (String dateTime) {
            instance.dateTime = dateTime;
            return this;
        }

        public WeatherData build() {
            return instance;
        }
    }
}
