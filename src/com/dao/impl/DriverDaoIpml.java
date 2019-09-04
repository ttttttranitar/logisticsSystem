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
            String sql = "insert into `driver` (`driver_id`,`driver_name`,`card`,`driver_phone`,`sex`,`birthdate`,`address`,`car_id`,`driver_info`,`driver_license`,`driver_permit`,`operation_license`,`insurance_license`) values (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            return updateDB(sql,driver.getDriver_id(),driver.getDriver_name(),driver.getCard(), driver.getDriver_phone(), driver.getSex(), driver.getBirthdate(),driver.getAddress(),driver.getCar_id(), driver.getDriver_info(), driver.getDriver_license(),driver.getDriver_permit(),driver.getOperation_license(), driver.getInsurance_license());
    }



    @Override
    public int modification(Driver driver_id) throws SQLException {
            String sql = "update  `driver` set `driver_name`=?,`card`=?,`driver_phone`=?,`sex`=?,`birthdate`=?,`address`=?,`car_id`=?,`driver_info`=?,`driver_license`=?,`driver_permit`=?,`operation_license`=?,`insurance_license`=? where `driver_id`=? ";
            return updateDB(sql, driver_id.getDriver_name(),driver_id.getCard(), driver_id.getDriver_phone(), driver_id.getSex(), driver_id.getBirthdate(),driver_id.getAddress(),driver_id.getCar_id(), driver_id.getDriver_info(), driver_id.getDriver_license(),driver_id.getDriver_permit(),driver_id.getOperation_license(), driver_id.getInsurance_license(),driver_id.getDriver_id());
    }
    @Override
    public List<Driver> getDriverList(int currentPage,int pageSize) throws SQLException {
        String sql = "select `driver_id`,`driver_name`,`card`,`driver_phone`,`sex`,`birthdate`,`address`,`car_id`,`driver_info`,`driver_license`,`driver_permit`,`operation_license`,`insurance_license` from `driver` limit ?,?";
        List<Driver> driverList = new ArrayList<>();
        try {
            res = queryDB(sql,(currentPage-1)*pageSize,pageSize);
            Driver driver = null;
            while (res.next()){
                driver = new Driver();
                driver.setDriver_id(res.getString("driver_id"));
                driver.setDriver_name(res.getString("driver_name"));
                driver.setCard(res.getString("card"));
                driver.setDriver_phone(res.getString("driver_phone"));
                driver.setSex(res.getString("sex"));
                driver.setBirthdate(res.getString("birthdate"));
                driver.setAddress(res.getString("address"));
                driver.setCar_id(res.getString("car_id"));
                driver.setDriver_info(res.getString("driver_info"));
                driver.setDriver_license(res.getString("driver_license"));
                driver.setDriver_permit(res.getString("driver_permit"));
                driver.setOperation_license(res.getString("operation_license"));
                driver.setInsurance_license(res.getString("insurance_license"));
                driverList.add(driver);
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return driverList;
    }


    @Override
    public Driver getDriverNumber(String driver_id) throws SQLException {
        String sql = "select `driver_name`,`card`,`driver_phone`,`sex`,`birthdate`,`address`,`car_id`,`driver_info`,`driver_license`,`driver_permit`,`operation_license`,`insurance_license`  from `driver` where `driver_id`=?";
        Driver driver;
        try {
            res = queryDB(sql,driver_id);
            driver = null;
            if(res.next()){
                driver = new Driver();
                driver.setDriver_name(res.getString("driver_name"));
                driver.setCard(res.getString("card"));
                driver.setDriver_phone(res.getString("driver_phone"));
                driver.setSex(res.getString("sex"));
                driver.setBirthdate(res.getString("birthdate"));
                driver.setAddress(res.getString("address"));
                driver.setCar_id(res.getString("car_id"));
                driver.setDriver_info(res.getString("driver_info"));
                driver.setDriver_license(res.getString("driver_license"));
                driver.setDriver_permit(res.getString("driver_permit"));
                driver.setOperation_license(res.getString("operation_license"));
                driver.setInsurance_license(res.getString("insurance_license"));
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return driver;
    }

    @Override
    public int getDriverCount() throws SQLException {
        int count = 0;
        String sql = "SELECT COUNT(driver_id) FROM driver";
        try {
            res = queryDB(sql,null);
            if (res.next()){
                count = res.getInt(1);
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return count;
    }

    @Override
    public int delete(String driver_id) throws SQLException {
        String sql ="DELETE FROM `driver` WHERE `driver_id`=?";
        return updateDB(sql,driver_id);
    }
}
