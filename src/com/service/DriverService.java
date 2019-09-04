package com.service;

import com.entity.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriverService {
    //新建司机信息
    int save(Driver driver);
    //根据司机ID修改司机信息
    int modification(Driver driver_id);
    //查询司机信息
    List<Driver> getDriverList(int currentPage,int pageSize);
    //根据司机ID查询司机信息
    Driver getDriverNumber(String driver_id);
    //总记录数
    int getDriverCount();
    //随机编号的生成
    String IDgenerator();
    //判断数据库中是否有该编号
    boolean isExist(String customer_id);
    //根据司机ID删除信息
    int delete(String driver_id);
}
