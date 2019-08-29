package com.service.impl;

import com.dao.TransportDao;
import com.dao.impl.TransportDaoImpl;
import com.entity.Transport;
import com.service.TransportService;

import java.sql.SQLException;
import java.util.List;

public class TransportServiceImpl implements TransportService {
    @Override
    public Transport getTransport(String transportId) {
        TransportDao dao=new TransportDaoImpl();
        Transport transport=null;
        try{
            transport=dao.getTransport(transportId);
        }catch (SQLException e){
            System.err.println("数据库错误");
            e.printStackTrace();
        }
        return transport;
    }

    @Override
    public List<Transport> getTransportList(int curretPage, int pageSize) {
        TransportDao dao=new TransportDaoImpl();
        List<Transport> transportList=null;
        try{
            transportList=dao.getTransportList(curretPage, pageSize);
        }catch (SQLException e){
            System.err.println("数据库错误");
            e.printStackTrace();
        }
        return transportList;
    }

    @Override
    public int addTransport(Transport transport,String orderId) {
        TransportDao dao=new TransportDaoImpl();
        int result=0;
        try{
            transport.setTransport_id(idGenerator(orderId));
            result=dao.addTransport(transport);
        }catch (SQLException e){
            System.err.println("数据库错误");
            e.printStackTrace();
            result=-1;
        }
        return result;
    }

    @Override
    public String idGenerator(String orderId)  {
        return "HY"+orderId;
    }


    @Override
    public int totalTransport() {
        TransportDao dao=new TransportDaoImpl();
        try{
            return dao.totalTransport();
        }catch(SQLException e){
            System.err.println("数据库错误");
            e.printStackTrace();
            return -1;
        }
    }
}
