package com.service.impl;

import com.dao.DriverDao;
import com.dao.impl.DriverDaoIpml;
import com.entity.Driver;
import com.service.DriverService;

import java.sql.SQLException;

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
    public Driver getDriver() {
        try {
            return new DriverDaoIpml().getDriver();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Driver getDriverNumber(Driver driver_id) {
        try {
            return new DriverDaoIpml().getDriverNumber(driver_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
