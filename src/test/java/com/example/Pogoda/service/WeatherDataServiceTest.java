package com.example.Pogoda.service;

import com.example.Pogoda.model.request.requestWeatherData.RequestWeatherData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WeatherDataServiceTest {

    WeatherDataService service = new WeatherDataService();

    @Test
    public void shouldGetRequestData() {
        //given
        //when
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "https://api.openweathermap.org/data/2.5/weather?id=7530991&APPID=9f5201d17b8aa222f6028ffa7317e378",
                String.class);

        //then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void shouldMapJsonToRequestWeatherData() throws IOException {
        //given
        File file = new ClassPathResource("JsonWeather.json").getFile();
        String content = new String(Files.readAllBytes(file.toPath()));

        //when
        RequestWeatherData request = service.mapJsonToRequestWeatherData(content);

        //then
        assertNotNull(request);
    }

}