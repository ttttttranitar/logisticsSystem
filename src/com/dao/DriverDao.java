package com.dao;

import com.entity.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriverDao {
    //新建司机信息
    int save(Driver driver) throws SQLException;
    //根据司机ID修改司机信息
    int modification(Driver driver_id) throws SQLException;
    //查询司机信息
    Driver getDriver() throws SQLException;
    //根据司机ID查询司机信息
    Driver getDriverNumber(Driver driver_id) throws SQLException;
}
