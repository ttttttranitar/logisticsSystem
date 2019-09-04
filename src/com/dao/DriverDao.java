package com.dao;

import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.entity.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriverDao {
    //新建司机信息
    int save(Driver driver) throws SQLException;
    //根据司机ID修改司机信息
    int modification(Driver driver_id) throws SQLException;
    //查询司机信息
    List<Driver> getDriverList(int currentPage,int pageSize) throws SQLException;
    //根据司机ID查询司机信息
    Driver getDriverNumber(String driver_id) throws SQLException;
    //总记录数
    int getDriverCount() throws SQLException;
    //根据司机ID删除信息
    int delete(String driver_id) throws SQLException;
}
