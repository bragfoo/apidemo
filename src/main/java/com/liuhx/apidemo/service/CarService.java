package com.liuhx.apidemo.service;

import com.liuhx.apidemo.model.query.Car;

import java.util.List;


public interface CarService {
    Car insert(Car car);
    Car findById(Long carId);
    int deleteById(Long carId);
    Car save(Car car);
    List<Car> findByBrand(String brand);
}
