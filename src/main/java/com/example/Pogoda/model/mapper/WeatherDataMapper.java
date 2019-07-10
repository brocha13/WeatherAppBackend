package com.example.Pogoda.model.mapper;

import com.example.Pogoda.model.WeatherData;
import com.example.Pogoda.model.request.requestWeatherData.RequestWeatherData;

public class WeatherDataMapper {
    public static WeatherData map(RequestWeatherData request){
        return new WeatherData.Builder()
                .withWeather(request.getWeather()[0].getMain())
                .withHumidity(request.getMain().getHumidity())
                .withPressure(request.getMain().getPressure())
                .withTemp(request.getMain().getTemp())
                .withTempMax(request.getMain().getTemp_max())
                .withTempMin(request.getMain().getTemp_min())
                .withWindSpeed(request.getWind().getSpeed())
                .build();
    }
}
