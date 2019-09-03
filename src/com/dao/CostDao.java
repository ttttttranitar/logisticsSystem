package com.dao;

import com.entity.Cost;

import java.sql.SQLException;
import java.util.List;

public interface CostDao {
    //新增费用
    int save(Cost cost) throws SQLException;
    //通过ID查询费用
    Cost getCostByID(int administrative_fee_id)throws SQLException;
    //查询成本
    Cost getCost()throws SQLException;
    //带分页的List
    List<Cost> getCostList(int page,int pagesize)throws SQLException;
    //总记录数
    int getCount()throws SQLException;
}
