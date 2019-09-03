package com.service;


import com.entity.Cost;

import java.util.List;

public interface CostService {
    //实现方法
    int save(Cost cost);
    //通过ID查询
    Cost getCostByID(int administrative_fee_id);
    //查询成本
    Cost getCost();
    //客户列表
    List<Cost> getCostList(int page, int pageSize);
    //总记录数
    int getCostCount();
}
