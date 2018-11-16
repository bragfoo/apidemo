package com.liuhx.apidemo.service.impl;

import com.liuhx.apidemo.config.properties.ThirdWeatherProperties;
import com.liuhx.apidemo.model.dto.weather.CityWeather;
import com.liuhx.apidemo.service.WeatherService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class WeatherServiceImpl implements WeatherService {

    private RestTemplate restTemplate;
    private ThirdWeatherProperties properties;

    public WeatherServiceImpl(RestTemplateBuilder builder, ThirdWeatherProperties properties) {
        this.restTemplate = builder
                .setConnectTimeout(Duration.ofSeconds(3))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();
        this.properties = properties;
    }

    @Override
    public CityWeather get(String cityName) {

        return restTemplate.getForObject(properties.getUri(), CityWeather.class, cityName);
    }
}
