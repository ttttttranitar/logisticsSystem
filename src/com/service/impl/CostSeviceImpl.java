package com.service.impl;

import com.dao.impl.CostDaoImpl;
import com.entity.Cost;
import com.service.CostService;

import java.sql.SQLException;

public class CostSeviceImpl implements CostService {

    @Override
    public double save(Cost cost) {//新增
        try {
            return new CostDaoImpl().save(cost);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Cost getcost() {//查询
        try {
            return new CostDaoImpl().getcost();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
