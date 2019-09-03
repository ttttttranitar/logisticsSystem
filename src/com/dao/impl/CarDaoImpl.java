package com.dao.impl;

import com.dao.CarDao;
import com.entity.Car;
import com.util.DButil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl extends DButil implements CarDao {
    @Override
    public int save(Car car) throws SQLException {
        String sql = "insert into `car`(`car_id`,`car_type`,`car_volume`,`car_lenght`,`car_weight`,`car_width`,`car_height`,`motor_id`,`VIN`,`company`,`is_company_car`,`company_tel`) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        return updateDB(sql,car.getCar_id(),car.getCar_type(),car.getCar_volume(),car.getCar_lenght(),car.getCar_weight(),car.getCar_width(),car.getCar_height(),car.getMotor_id(),car.getVIN(),car.getCompany(),car.getIs_company_car(),car.getCompany_tel());
    }

    @Override
    public Car getCarNumber(String car_id) throws SQLException {
        String sql = "select `car_type`,`car_volume`,`car_lenght`,`car_weight`,`car_width`,`car_height`,`motor_id`,`VIN`,`company`,`is_company_car`,`company_tel` from `car` where `car_id`=?";
        Car car;
        try {
            res = queryDB(sql,car_id);
            car = null;
            if(res.next()){
                car = new Car();
                car.setCar_type(res.getString("car_type"));
                car.setCar_volume(res.getDouble("car_volume"));
                car.setCar_lenght(res.getDouble("car_lenght"));
                car.setCar_weight(res.getDouble("car_weight"));
                car.setCar_width(res.getDouble("car_width"));
                car.setCar_height(res.getDouble("car_height"));
                car.setMotor_id(res.getString("motor_id"));
                car.setVIN(res.getString("VIN"));
                car.setCompany(res.getString("company"));
                car.setIs_company_car(res.getInt("is_company_car"));
                car.setCompany_tel(res.getString("company_tel"));
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return car;
    }

    @Override
    public List<Car> getCarList() throws SQLException {
        List<Car> carList = new ArrayList<>();
        String sql = "select `car_id`,`car_type`,`car_volume`,`car_lenght`,`car_weight`,`car_height`,`motor_id`,`VIN`,`company`,`is_company_car`,`company_tel` from `car`";
        Car car;
        try {
            res = queryDB(sql);
            car = null;
            while (res.next()){
                car = new Car();
                car.setCar_id(res.getString("car_id"));
                car.setCar_type(res.getString("car_type"));
                car.setCar_volume(res.getDouble("car_volume"));
                car.setCar_lenght(res.getDouble("car_lenght"));
                car.setCar_weight(res.getDouble("car_weight"));
                car.setCar_width(res.getDouble("car_width"));
                car.setCar_height(res.getDouble("car_height"));
                car.setMotor_id(res.getString("motor_id"));
                car.setVIN(res.getString("VIN"));
                car.setCompany(res.getString("company"));
                car.setIs_company_car(res.getInt("is_company_car"));
                car.setCompany_tel(res.getString("company_tel"));
                carList.add(car);
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return carList;
    }
}
