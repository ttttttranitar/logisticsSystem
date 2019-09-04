package com.service.impl;

import com.dao.ClientDao;
import com.dao.DriverDao;
import com.dao.impl.ClientDaoImpl;
import com.dao.impl.DriverDaoIpml;
import com.entity.Client;
import com.entity.Driver;
import com.service.DriverService;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class DriverServiceImpl implements DriverService {

    @Override
    public int save(Driver driver) {
        try {
            return new DriverDaoIpml().save(driver);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int modification(Driver driver_id) {
        try {
            return new DriverDaoIpml().modification(driver_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Driver> getDriverList(int currentPage,int pageSize) {
        try {
            return new DriverDaoIpml().getDriverList(currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Driver getDriverNumber(String driver_id) {
        try {
            return new DriverDaoIpml().getDriverNumber(driver_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getDriverCount() {
        try {
            return new DriverDaoIpml().getDriverCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public String IDgenerator() {
        Random random = new Random();
        Boolean isExists = false;
        String customerID = "";
        do {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<6;i++) {
                sb.append(random.nextInt(10));
            }
            customerID = "SJ"+sb;
            if (isExist(customerID)){
                isExists=true;
            }
        }while (isExists);
        return customerID;
    }
    @Override
    public boolean isExist(String customer_id) {
        DriverDao driverDao = new DriverDaoIpml();
        Driver driver = null;
        try {
            driver = driverDao.getDriverNumber(customer_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (driver!=null){
            return true;
        }
        return false;
    }

    @Override
    public int delete(String driver_id) {
        try {
            return new DriverDaoIpml().delete(driver_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
