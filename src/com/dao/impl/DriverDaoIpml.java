package com.dao.impl;

import com.dao.DriverDao;
import com.entity.Driver;
import com.util.DButil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDaoIpml extends DButil implements DriverDao {
    @Override
    public int save(Driver driver) throws SQLException {//新增
            String sql = "insert into `driver` (`driver_id`,`driver_name`,`driver_phone`,`sex`,`birthdate`,`car_id`,`driver_info`,`driver_license`,`operation_license`,`insurance_license`) values (?,?,?,?,?,?,?,?,?,?) ";
            return updateDB(sql,driver.getDriver_id(),driver.getDriver_name(), driver.getDriver_phone(), driver.getSex(), driver.getBirthdate(), driver.getCar_id(), driver.getDriver_info(), driver.getDriver_license(), driver.getInsurance_license());
    }

    @Override
    public int modification(Driver driver_id) throws SQLException {//修改
            String sql = "update  `driver` set (`driver_name`=?,`driver_phone`=?,`sex`=?,`birthdate`=?,`car_id`=?,`driver_info`=?,`driver_license`=?,`operation_license`=?,`insurance_license`=?) where `driver_id`=? ";
            return updateDB(sql, driver_id.getDriver_name(), driver_id.getDriver_phone(), driver_id.getSex(), driver_id.getBirthdate(), driver_id.getCar_id(), driver_id.getDriver_info(), driver_id.getDriver_license(), driver_id.getInsurance_license());
    }
    @Override
    public Driver getDriver() throws SQLException {//查询
        String sql = "select `driver_id`,`driver_name`,`driver_phone`,`sex`,`birthdate`,`car_id`,`driver_info`,`driver_license`,`operation_license`,`insurance_license` from `driver` ";
        Driver driver;
        try {
            res = queryDB(sql);
            driver = null;
            if(res.next()){
                driver = new Driver();
                driver.setDriver_id(res.getString("driver_id"));
                driver.setDriver_name(res.getString("driver_name"));
                driver.setDriver_phone(res.getString("driver_phone"));
                driver.setSex(res.getString("sex"));
                driver.setBirthdate(res.getString("birthdate"));
                driver.setCar_id(res.getString("car_id"));
                driver.setDriver_info(res.getString("driver_info"));
                driver.setDriver_license(res.getString("driver_license"));
                driver.setOperation_license(res.getString("operation_license"));
                driver.setInsurance_license(res.getString("insurance_license"));
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return driver;
    }

    @Override
    public Driver getDriverNumber(Driver driver_id) throws SQLException {
        String sql = "select `driver_name`,`driver_phone`,`sex`,`birthdate`,`car_id`,`driver_info`,`driver_license`,`operation_license`,`insurance_license` from `driver` where `driver_id`=?";
        Driver driver;
        try {
            res = queryDB(sql,driver_id);
            driver = null;
            if(res.next()){
                driver = new Driver();
                driver.setDriver_id(res.getString("driver_id"));
                driver.setDriver_name(res.getString("driver_name"));
                driver.setDriver_phone(res.getString("driver_phone"));
                driver.setSex(res.getString("sex"));
                driver.setBirthdate(res.getString("birthdate"));
                driver.setCar_id(res.getString("car_id"));
                driver.setDriver_info(res.getString("driver_info"));
                driver.setDriver_license(res.getString("driver_license"));
                driver.setOperation_license(res.getString("operation_license"));
                driver.setInsurance_license(res.getString("insurance_license"));
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return driver;
    }
}
