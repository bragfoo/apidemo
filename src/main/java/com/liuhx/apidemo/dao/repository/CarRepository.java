package com.liuhx.apidemo.dao.repository;

import com.liuhx.apidemo.model.query.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarRepository extends MongoRepository<Car,String> {
    Car findByCarId(Long carId);
    int deleteByCarId(Long carId);
    List<Car> findByBrand(String brand);
}
