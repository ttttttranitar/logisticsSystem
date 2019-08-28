package com.dao;

import com.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    public Order getOrder(String orderId) throws SQLException;
    public List<Order> getOrderList(int currentPage,int pageSize) throws SQLException;
    public int addOrder(Order order) throws SQLException;
    public boolean isExisting(String orderId) throws SQLException;
    public int changeStatue(String statue,String orderId) throws  SQLException;
}
