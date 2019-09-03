package com.dao;

import com.entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    //新增
    int save(Car car) throws SQLException;
    //根据车牌号查车
    Car getCarNumber(String car_id) throws SQLException;
    //查询所有车的信息
    List<Car> getCarList() throws SQLException;
}
