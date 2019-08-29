package com.service;

import com.entity.Client;

import java.util.List;

public interface ClientService {
    //实现方法
    int save(Client client);
    //判断数据库中是否有该编号
    boolean isExist(String customer_id);
    //随机编号的生成
    String IDgenerator();
    //客户列表
    List<Client> getClientList();
}
