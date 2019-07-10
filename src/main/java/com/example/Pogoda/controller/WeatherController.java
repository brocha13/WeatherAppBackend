package com.example.Pogoda.controller;

import com.example.Pogoda.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {

    @Autowired
    WeatherDataService service;

    @ResponseBody
    @RequestMapping("/getWeatherData")
    public ResponseEntity<Object> getWeatherData(@RequestParam("date") String date){
        try {
            return new ResponseEntity<>(service.findByDateTime(date),HttpStatus.OK);
        } catch (IndexOutOfBoundsException e) { }
        return new ResponseEntity<>("No measurements at this time", HttpStatus.BAD_REQUEST);
    }
}
