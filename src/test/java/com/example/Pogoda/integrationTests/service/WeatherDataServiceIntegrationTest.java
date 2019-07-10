package com.example.Pogoda.integrationTests.service;

import com.example.Pogoda.model.WeatherData;
import com.example.Pogoda.repo.WeatherDataRepository;
import com.example.Pogoda.service.WeatherDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
public class WeatherDataServiceIntegrationTest {

    @Autowired
    WeatherDataService service;

    @TestConfiguration
    static class WeatherDataServiceTestContextConfiguration {

        @Bean
        public WeatherDataService employeeService() {
            return new WeatherDataService();
        }
    }

    @MockBean
    private WeatherDataRepository repository;

    @Before
    public void setUp() {
        WeatherData data =new WeatherData.Builder()
                .withHumidity(12)
                .withPressure(13)
                .withTemp(15.5)
                .withTempMax(17.12)
                .withTempMin(12.1)
                .withWeather("cloudy")
                .withWindSpeed(13.15)
                .withDateTime("2019-07-06 12")
                .build();

        Mockito.when(repository.findAllByDateTime(data.getDateTime()))
                .thenReturn(Collections.singletonList(data));
    }

    @Test
    public void shouldReturnWeatherDataWhenFindByDateTime() {
        // given

        // when
        WeatherData found = service.findByDateTime("2019-07-06 12");

        // then
        assertNotNull(found);
    }
}