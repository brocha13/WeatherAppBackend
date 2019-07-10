package com.example.Pogoda.service;

import com.example.Pogoda.model.WeatherData;
import com.example.Pogoda.model.mapper.WeatherDataMapper;
import com.example.Pogoda.model.request.requestWeatherData.RequestWeatherData;
import com.example.Pogoda.repo.WeatherDataRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataService {

    @Autowired
    private WeatherDataRepository repository;

    @Scheduled(fixedRate = 3600000)
    public void saveToDatabase() {
        RequestWeatherData request= mapJsonToRequestWeatherData(getRequestJsonData().getBody());

        if(request!=null) {
            repository.save(WeatherDataMapper.map(request));
        }
    }

    public WeatherData findByDateTime(String date){
        return repository.findAllByDateTime(date).get(0);
    }

    public RequestWeatherData mapJsonToRequestWeatherData(String json){
        return new Gson().fromJson(json, RequestWeatherData.class);
    }

    private ResponseEntity<String> getRequestJsonData(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(
                "https://api.openweathermap.org/data/2.5/weather?id=7530991&APPID=9f5201d17b8aa222f6028ffa7317e378",
                String.class);
    }
}
