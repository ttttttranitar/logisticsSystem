package com.service;

import com.entity.Order;

import java.util.List;

public interface OrderService {
    public Order getOrder(String orderId);
    public List<Order> getOrderList(int curretPage,int pageSize);
    public int addOrder(Order order);
    public String idGenerator();
    public int changeStatue(String statue,String orderId);
    public  int totalOrder();
}
