package com.example.Pogoda.integrationTests.repository;

import com.example.Pogoda.model.WeatherData;
import com.example.Pogoda.repo.WeatherDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WeatherDataRepositoryIntegrationTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    WeatherDataRepository repository;

    @Test
    public void whenFindByDateTime_thenReturnWeatherData() {
        // given
        WeatherData data = new WeatherData.Builder()
                .withHumidity(12)
                .withPressure(13)
                .withTemp(15.5)
                .withTempMax(17.12)
                .withTempMin(12.1)
                .withWeather("cloudy")
                .withWindSpeed(13.15)
                .build();

        entityManager.persist(data);
        entityManager.flush();

        // when
        List<WeatherData> found = repository.findAllByDateTime(data.getDateTime());

        // then
        assertEquals(found.get(0).getId(), data.getId());
    }
}