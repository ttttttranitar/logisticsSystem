package com.dao;


import com.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {
    //新增客户
    int save(Client client) throws SQLException;
    //修改客户
    int update(Client client) throws SQLException;
    //删除客户
    int del(String customer_id)throws SQLException;
    //通过编号查询客户
    Client getClientByID(String customer_id) throws SQLException;
    //带参数的客户列表
    List<Client> getClientList(int currentPage,int pageSize) throws SQLException;
    //总页数
    int getClientCount()throws SQLException;
}
