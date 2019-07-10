package com.example.Pogoda.repo;

import com.example.Pogoda.model.WeatherData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherDataRepository extends CrudRepository<WeatherData, Long> {

    List<WeatherData> findAllByDateTime(String dateTime);
}
