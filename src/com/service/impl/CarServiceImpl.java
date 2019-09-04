package com.service.impl;

import com.dao.impl.CarDaoImpl;
import com.entity.Car;
import com.service.CarService;

import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public int save(Car car) {
        try {
            return new CarDaoImpl().save(car);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Car getCarNumber(String car_id) {
        try {
            return new CarDaoImpl().getCarNumber(car_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Car> getCarList() {
        try {
            return new CarDaoImpl().getCarList();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int modification(Car car_id) {
        try {
            return new CarDaoImpl().modification(car_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
