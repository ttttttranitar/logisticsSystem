package com.service.impl;

import com.dao.impl.CardriverDaoImpl;
import com.entity.Cardriver;
import com.service.CardriverService;

import java.sql.SQLException;

public class CardriverServiceImpl implements CardriverService {
    @Override
    public Cardriver cardriver(String driver_id) {
        try {
            return new CardriverDaoImpl().cardriver(driver_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
