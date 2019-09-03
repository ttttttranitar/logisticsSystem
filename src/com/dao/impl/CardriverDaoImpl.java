package com.dao.impl;

import com.dao.CardriverDao;
import com.entity.Cardriver;
import com.util.DButil;

import java.sql.SQLException;

public class CardriverDaoImpl extends DButil implements CardriverDao {
    @Override
    public Cardriver cardriver(String driver_id) throws SQLException {//24
        String sql = "select `driver_name`,`card`,`driver_phone`,`sex`,`birthdate`,`address`,`car_id`,`driver_info`,`driver_license`,`driver_permit`,`operation_license`,`insurance_license`,`car_type`,`car_volume`,`car_lenght`,`car_weight`,`car_width`,`car_height`,`motor_id`,`VIN`,`company`,`is_company_car`,`company_tel` from  where `driver_id`=?";
       Cardriver cardriver;
        try {
            res = queryDB(sql,driver_id);
           cardriver = null;
           while (res.next()){
               cardriver = new Cardriver();
               cardriver.setDriver_name(res.getString("driver_name"));
               cardriver.setCard(res.getString("card"));
               cardriver.setDriver_phone(res.getString("driver_phone"));
               cardriver.setSex(res.getString("sex"));
               cardriver.setBirthdate(res.getString("birthdate"));
               cardriver.setAddress(res.getString("address"));
               cardriver.setCar_id(res.getString("car_id"));
               cardriver.setDriver_info(res.getString("driver_info"));
               cardriver.setDriver_license(res.getString("driver_license"));
               cardriver.setDriver_permit(res.getString("driver_permit"));
               cardriver.setOperation_license(res.getString("operation_license"));
               cardriver.setInsurance_license(res.getString("insurance_license"));
               cardriver.setCar_id(res.getString("car_id"));
               cardriver.setCar_type(res.getString("car_type"));
               cardriver.setCar_volume(res.getDouble("car_volume"));
               cardriver.setCar_lenght(res.getDouble("car_lenght"));
               cardriver.setCar_weight(res.getDouble("car_weight"));
               cardriver.setCar_width(res.getDouble("car_width"));
               cardriver.setCar_height(res.getDouble("car_height"));
               cardriver.setMotor_id(res.getString("motor_id"));
               cardriver.setVIN(res.getString("VIN"));
               cardriver.setCompany(res.getString("company"));
               cardriver.setIs_company_car(res.getInt("is_company_car"));
               cardriver.setCompany_tel(res.getString("company_tel"));
           }
        } finally {
            closeALL(conn,stat,res);
        }
        return cardriver;
    }
}
