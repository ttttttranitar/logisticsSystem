package com.service.impl;

import com.dao.OrderDao;
import com.dao.impl.OrderDaoImpl;
import com.entity.Order;
import com.service.OrderService;

import java.text.SimpleDateFormat;
import  java.util.*;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order getOrder(String orderId) {
        try{
            return new OrderDaoImpl().getOrder(orderId);
        }catch (SQLException e){
            System.err.println("数据库查询错误");
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List<Order> getOrderList(int currentPage,int pageSize) {
        try{
            return new OrderDaoImpl().getOrderList(currentPage,pageSize);
        }catch (SQLException e){
            System.err.println("数据库错误");
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int addOrder(Order order) {
        try{
            order.setOrder_id(idGenerator());
            return new OrderDaoImpl().addOrder(order);
        }catch (SQLException e){
            System.err.println("数据库错误");
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public   String idGenerator() {
        OrderDao dao=new OrderDaoImpl();
        Date now=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyMMdd");
        String id="";
        try{
            do{
                 id=dateFormat.format(now)+String.valueOf(Math.random()*10000).substring(0, 4);//将double型数据转化为String并截取前4位
            }while(dao.isExisting(id));
        }catch(SQLException e){
            System.err.println("数据库查询错误");
            id="";
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int changeStatue(String statue, String orderId) {
        OrderDao dao=new OrderDaoImpl();
        int result=0;
        try{
           result=dao.changeStatue(statue,orderId);
        }catch (SQLException e){
            System.err.println("数据库错误");
            result=-1;
            e.printStackTrace();
        }
        return  result;
    }

    @Override
    public int totalOrder() {
        try{
            return new OrderDaoImpl().totalOrder();
        }catch (SQLException e){
            System.out.println("数据库错误");
            e.printStackTrace();
            return -1;
        }
    }
}
