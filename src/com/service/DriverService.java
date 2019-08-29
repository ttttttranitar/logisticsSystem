package com.service;

import com.entity.Driver;

public interface DriverService {
    //新建司机信息
    int save(Driver driver);
    //根据司机ID修改司机信息
    int modification(Driver driver_id);
    //查询司机信息
    Driver getDriver();
    //根据司机ID查询司机信息
    Driver getDriverNumber(Driver driver_id);
}
