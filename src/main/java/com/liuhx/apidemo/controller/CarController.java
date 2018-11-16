package com.liuhx.apidemo.controller;

import com.liuhx.apidemo.model.query.Car;
import com.liuhx.apidemo.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program apidemo
 * @description:
 * @author: liuhx
 * @create: 2018/11/16 12:11
 */
@RestController
@RequestMapping("car")
public class CarController {
    @Resource
    CarService carService;

    @PostMapping("insert")
    public Car insert(Car car) {
        return carService.insert(car);
    }

    @GetMapping("findById")
    public Car findById(Long carId) {
        return carService.findById(carId);
    }

    @PostMapping("deleteById")
    public int deleteById(Long carId) {
        return carService.deleteById(carId);
    }

    @PostMapping("save")
    public Car save(Car car) {
        return carService.save(car);
    }

    @GetMapping("findByBrand")
    public List<Car> findByBrand(String brand) {
        return carService.findByBrand(brand);
    }
}
