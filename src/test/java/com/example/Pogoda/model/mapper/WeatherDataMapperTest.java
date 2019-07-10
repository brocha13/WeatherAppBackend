package com.example.Pogoda.model.mapper;

import com.example.Pogoda.factory.RequestWeatherDataFactory;
import com.example.Pogoda.model.WeatherData;
import com.example.Pogoda.model.request.requestWeatherData.RequestWeatherData;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDataMapperTest {

    @Test
    public void shouldMapRequestWeatherDataToWeatherData() {
        //given
        final RequestWeatherData request = RequestWeatherDataFactory.makeAny();

        //when
        final WeatherData weatherData = WeatherDataMapper.map(request);

        //then
        assertEquals(weatherData.getHumidity(),request.getMain().getHumidity());
        assertEquals(weatherData.getPressure(),request.getMain().getPressure());
        assertEquals(weatherData.getTemp(),request.getMain().getTemp());
        assertEquals(weatherData.getTempMax(),request.getMain().getTemp_max());
        assertEquals(weatherData.getTempMin(),request.getMain().getTemp_min());
        assertEquals(weatherData.getWeather(),request.getWeather()[0].getMain());
        assertEquals(weatherData.getWindSpeed(),request.getWind().getSpeed());
    }
}