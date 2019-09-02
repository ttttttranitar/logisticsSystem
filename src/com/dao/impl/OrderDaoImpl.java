package com.dao.impl;

import com.dao.OrderDao;
import com.entity.Order;
import com.util.DButil;

import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends DButil implements OrderDao {
    private List<Order> orderList=new ArrayList<Order>();

    @Override
    public Order getOrder(String orderId) throws SQLException {
        String sql="select * from custom_order where order_id=?";
        Order order=null;
        try{
            res=queryDB(sql,orderId);
            if(res.next()){
                 order=new Order();
                 order.setOrder_id(res.getString("order_id"));
                 order.setSender_id(res.getString("sender_id"));
                 order.setSender_name(res.getString("sender_name"));
                 order.setSender_phone(res.getString("sender_phone"));
                 order.setSender_address(res.getString("sender_address"));
                 order.setReciever_id(res.getString("reciever_id"));
                 order.setReciever_name(res.getString("reciever_name"));
                 order.setReciever_phone(res.getString("reciever_phone"));
                 order.setReciever_address(res.getString("reciever_address"));
                 order.setSubmit_date(res.getString("submit_date"));
                 order.setOrder_statue(res.getString("order_statue"));
                 order.setOrder_amount(res.getDouble("order_amount"));
            }
            return order;
        }finally {
            closeALL(conn,stat,res);
        }
    }

    @Override
    public List<Order> getOrderList(int currentPage, int pageSize) throws SQLException {
        String sql="select * from custom_order limit ?,?";
        Order order=null;
        try{
            res=queryDB(sql,(currentPage-1)*pageSize,pageSize);
            while(res.next()){
                order=new Order();
                order.setOrder_id(res.getString("order_id"));
                order.setSender_id(res.getString("sender_id"));
                order.setSender_name(res.getString("sender_name"));
                order.setSender_phone(res.getString("sender_phone"));
                order.setSender_address(res.getString("sender_address"));
                order.setReciever_id(res.getString("reciever_id"));
                order.setReciever_name(res.getString("reciever_name"));
                order.setReciever_phone(res.getString("reciever_phone"));
                order.setReciever_address(res.getString("reciever_address"));
                order.setSubmit_date(res.getString("submit_date"));
                order.setOrder_statue(res.getString("order_statue"));
                order.setOrder_amount(res.getDouble("order_amount"));
                orderList.add(order);
            }

        }finally {
            closeALL(conn,stat,res);
        }
        return  orderList;
    }

    @Override
    public int addOrder(Order order) throws SQLException {
        String sql="insert into custom_order value(?,?,?,?,?,?,?,?,?,?,?,?)";
        int result=0;
        result=updateDB(sql,order.getOrder_id(),order.getSender_id(),order.getSender_name(),order.getSender_phone(),order.getSender_address(),order.getReciever_id(),order.getReciever_name(),order.getSender_phone(),order.getReciever_address(),order.getOrder_statue(),order.getOrder_amount(),order.getSubmit_date());
        return result;
    }

    @Override
    public boolean isExisting(String orderId) throws  SQLException{
        String sql="select order_id from custom_order where order_id=?";
        try{
            res=queryDB(sql,orderId);
            return res.next();
        }finally {
            closeALL(conn,stat,res);
            return false;
        }

    }

    @Override
    public int changeStatue(String statue,String orderId) throws SQLException {
        String sql="update custom_order set order_statue=? where order_id=?";
        int result=0;
        result=updateDB(sql,statue,orderId);
        return result;
    }

    @Override
    public int totalOrder() throws SQLException{
        String sql="select count(order_id) from custom_order";
        int result=0;
        try{
             res=queryDB(sql);
             if(res.next())
                 result=res.getInt(1);
            return  result;
        }finally {
            closeALL(conn,stat,res);
        }
    }

    @Override
    public int delOrder(String orderId) throws  SQLException{
        try{
            String sql="{call del_order(?,?)}";//调用存储过程
            callStat=getConnection().prepareCall(sql);
            callStat.setString(1,orderId);
            callStat.registerOutParameter(2,Types.INTEGER);
            callStat.execute();
            return  callStat.getInt(2);//获取返回参数
        }finally {
            closeALL(conn,callStat,res);
        }
    }
}
