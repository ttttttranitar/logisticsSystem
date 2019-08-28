package com.dao;


import com.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {
    //新增客户
    int save(Client client) throws SQLException;
    //通过编号查询客户
    Client getClientByID(String customer_id) throws SQLException;
    //不带参数的客户列表
    List<Client> getUserListPage() throws SQLException;
}
