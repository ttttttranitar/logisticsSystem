package com.dao;

import com.entity.Cardriver;

import java.sql.SQLException;

public interface CardriverDao {
    //司机管理的详情查询
    Cardriver cardriver(String driver_id) throws SQLException;
}
