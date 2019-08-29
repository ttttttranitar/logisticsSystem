package com.dao;

import com.entity.Cost;

import java.sql.SQLException;

public interface CostDao {
    //新增费用
    int save(Cost cost) throws SQLException;
    //查询费用
    Cost getcost()throws SQLException;
}
