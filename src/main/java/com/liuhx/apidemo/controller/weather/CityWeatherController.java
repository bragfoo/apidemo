package com.liuhx.apidemo.controller.weather;

import com.liuhx.apidemo.model.dto.weather.CityWeather;
import com.liuhx.apidemo.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("weather")
public class CityWeatherController {

    @Resource
    WeatherService weatherService;

    @GetMapping("/{cityName}")
    public CityWeather cityWeather(@PathVariable String cityName) {
        return weatherService.get(cityName);
    }

}
