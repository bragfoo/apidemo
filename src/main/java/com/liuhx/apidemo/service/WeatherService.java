package com.liuhx.apidemo.service;


import com.liuhx.apidemo.model.dto.weather.CityWeather;

public interface WeatherService {

    CityWeather get(String cityName);
}
