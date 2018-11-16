package com.liuhx.apidemo.service.impl;

import com.liuhx.apidemo.dao.repository.CarRepository;
import com.liuhx.apidemo.model.query.Car;
import com.liuhx.apidemo.service.CarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program apidemo
 * @description: 车辆管理 mongo
 * @author: liuhx
 * @create: 2018/11/16 11:43
 */
@Service
public class CarServiceImpl implements CarService {
    @Resource
    CarRepository carRepository;


    @Override
    public Car insert(Car car) {
        return carRepository.insert(car);
    }

    @Override
    public Car findById(Long carId) {

        return carRepository.findByCarId(carId);
    }

    @Override
    public int deleteById(Long carId) {
        return carRepository.deleteByCarId(carId);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }


}
