package com.service.impl;

import com.dao.impl.CostDaoImpl;
import com.entity.Cost;
import com.service.CostService;

import java.sql.SQLException;
import java.util.List;

public class CostSeviceImpl implements CostService {

    @Override
    public int save(Cost cost) {//新增
        try {
            return new CostDaoImpl().save(cost);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Cost getCostByID(int administrative_fee_id) {//通过id查询
        try {
            return new CostDaoImpl().getCostByID(administrative_fee_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cost getCost() {//成本表
        try {
            return new CostDaoImpl().getCost();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cost> getCostList(int page, int pageSize) {
        try {
            return new CostDaoImpl().getCostList(page,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getCostCount() {//总记录数
        try {
            return new CostDaoImpl().getCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


}
