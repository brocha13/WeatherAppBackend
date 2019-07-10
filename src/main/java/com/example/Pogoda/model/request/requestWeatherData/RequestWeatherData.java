package com.example.Pogoda.model.request.requestWeatherData;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class RequestWeatherData {

    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private long id;
    private String name;
    private int cod;

    public RequestWeatherData(Coord coord, Weather[] weather, String base, Main main, int visibility, Wind wind, Clouds clouds, long dt, Sys sys, int timezone, long id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public static class Coord{
        private double lon;
        private double lat;

        public Coord(double lon, double lat) {
            this.lon = lon;
            this.lat = lat;
        }
    }

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public static class Weather{
        private int id;
        private String main;
        private String descpription;
        private String icon;

        public Weather(int id, String main, String descpription, String icon) {
            this.id = id;
            this.main = main;
            this.descpription = descpription;
            this.icon = icon;
        }
    }

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public static class Main{
        private double temp;
        private int pressure;
        private int humidity;
        private double temp_min;
        private double temp_max;

        public Main(double temp, int pressure, int humidity, double temp_min, double temp_max) {
            this.temp = temp;
            this.pressure = pressure;
            this.humidity = humidity;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
        }
    }

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public static class Wind{
        private double speed;
        private int deg;

        public Wind(double speed, int deg) {
            this.speed = speed;
            this.deg = deg;
        }
    }

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public static class Clouds{
        private int all;

        public Clouds(int all) {
            this.all = all;
        }
    }

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.PUBLIC)
    public static class Sys{
        private int type;
        private int id;
        private double message;
        private String country;
        private long sunrise;
        private long sunset;

        public Sys(int type, int id, double message, String country, long sunrise, long sunset) {
            this.type = type;
            this.id = id;
            this.message = message;
            this.country = country;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }
    }
}
