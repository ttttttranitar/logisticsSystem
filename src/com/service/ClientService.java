package com.service;

import com.entity.Client;

import java.util.List;

public interface ClientService {
    //新增方法
    int save(Client client);
    //修改
    int update(Client client);
    //删除
    int del(String customer_id);
    //判断数据库中是否有该编号
    boolean isExist(String customer_id);
    //通过编号查找到客户
    Client getClientByID(String customer_id);
    //随机编号的生成
    String IDgenerator();
    //客户列表
    List<Client> getClientList(int currentPage,int pageSize);
    //总记录数
    int getClientCount();
}
