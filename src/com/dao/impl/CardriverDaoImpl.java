package com.dao.impl;

import com.dao.CardriverDao;
import com.entity.Cardriver;
import com.util.DButil;

import java.sql.SQLException;

public class CardriverDaoImpl extends DButil implements CardriverDao {
    @Override
    public Cardriver cardriver(String driver_id) throws SQLException {//24
        /*String sql = "SELECT  car.*,driver_id,driver_name,sex,birthdate,card,driver_license,operation_license,insurance_license,driver_permit,address,driver_info FROM car, driver WHERE car.car_id=driver.car_id AND `driver_id`=?";*/

        String sql = "SELECT d.`driver_id`,d.`driver_name`,d.`card`,d.`driver_phone`,d.`sex`,d.`birthdate`,d.`address`,d.`car_id`,d.`driver_info`,d.`driver_license`,d.`driver_permit`,d.`operation_license`,d.`insurance_license`,c.`car_type`,c.`car_volume`,c.`car_lenght`,c.`car_weight`,c.`car_width`,c.`car_height`,c.`motor_id`,c.`VIN`,c.`company`,c.`company_tel`,c.`is_company_car` FROM `driver` d,`car` c WHERE d.`car_id`=c.`car_id` AND  d.`car_id`=?";

//        String sql="SELECT * FROM v_car_diver WHERE driver_id=?";
        Cardriver cardriver;
        try {
            res = queryDB(sql,driver_id);
           cardriver = null;
           if (res.next()){
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
