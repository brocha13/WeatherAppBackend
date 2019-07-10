package com.example.Pogoda.factory;

import com.example.Pogoda.model.request.requestWeatherData.RequestWeatherData;

public class RequestWeatherDataFactory {
    private static RequestWeatherData instance;
    private static RequestWeatherData.Coord coord = new RequestWeatherData.Coord(15.51,51.94);
    private static RequestWeatherData.Clouds clouds= new RequestWeatherData.Clouds(75);

    private static RequestWeatherData.Main main = new RequestWeatherData.Main(
            293.54,
            1013,
            49,
            293.15,
            293.71);

    private static RequestWeatherData.Sys sys = new RequestWeatherData.Sys(
            1,
            1714,
            0.0076,
            "PL",
            1562294717,
            1562354357);

    private static RequestWeatherData.Weather weather = new RequestWeatherData.Weather(
            803,
            "Clouds",
            "broken clouds",
            "04d");

    private static RequestWeatherData.Wind wind = new RequestWeatherData.Wind(6.7,270);

    public static RequestWeatherData makeAny(){
        RequestWeatherData.Weather[] weathers = new RequestWeatherData.Weather[1];
        weathers[0] = weather;
        instance = new RequestWeatherData(
                coord,
                weathers,
                "stations",
                main,
                10000,
                wind,
                clouds,
                1562339437,
                sys,
                7200,
                7530991,
                "Zielona Góra",
                200);

        return instance;
    }
}
