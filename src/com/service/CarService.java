package com.service;

import com.entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarService {
    //新增
    int save(Car car);
    //根据车牌号查车
    Car getCarNumber(String car_id);
    //查询所有车的信息
    List<Car> getCarList();
}
