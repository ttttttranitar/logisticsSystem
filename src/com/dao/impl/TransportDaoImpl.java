package com.dao.impl;

import com.dao.TransportDao;
import com.entity.Transport;
import com.util.DButil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportDaoImpl extends DButil implements TransportDao {
    private List<Transport> transports=new ArrayList<Transport>();
    @Override
    public Transport getTransport(String transportId) throws SQLException {
        String sql="select * from transport where transport_id=?";
        Transport transport=null;
        try{
            res=queryDB(sql,transportId);
            if(res.next()){
                transport=new Transport();
                transport.setTransport_id(transportId);
                transport.setTransport_start(res.getString("transport_start"));
                transport.setTransport_distinatin(res.getString("transport_distinatin"));
                transport.setPay_type(res.getString("pay_type"));
                transport.setTransport_fee(res.getString("transport_fee"));
                transport.setInsurance_fee(res.getString("insurance_fee"));
                transport.setStart_date(res.getString("start_date"));
                transport.setEnd_date(res.getString("end_date"));
                transport.setTransport_info(res.getString("transport_info"));
            }
        }finally {
            closeALL(conn,stat,res);
        }
        return transport;
    }

    @Override
    public List<Transport> getTransportList(int currentPage, int pageSize) throws SQLException {
        String sql="select * from transport ";
        Transport transport=null;
        try{
            res=queryDB(sql);
            while(res.next()){
                transport=new Transport();
                transport.setTransport_id(res.getString("transport_id"));
                transport.setTransport_start(res.getString("transport_start"));
                transport.setTransport_distinatin(res.getString("transport_distinatin"));
                transport.setPay_type(res.getString("pay_type"));
                transport.setTransport_fee(res.getString("transport_fee"));
                transport.setInsurance_fee(res.getString("insurance_fee"));
                transport.setStart_date(res.getString("start_date"));
                transport.setEnd_date(res.getString("end_date"));
                transport.setTransport_info(res.getString("transport_info"));
                transports.add(transport);
            }
        }finally {
            closeALL(conn,stat,res);
        }
        return transports;
    }

    @Override
    public int addTransport(Transport transport) throws SQLException {
        String sql="insert into transport value(?,?,?,?,?,?,?,?,?)";
        int result=0;
        result=updateDB(sql,transport.getTransport_id(),transport.getStart_date(),transport.getEnd_date(),transport.getPay_type(),transport.getTransport_fee(),transport.getInsurance_fee(),transport.getTransport_start(),transport.getTransport_distinatin(),transport.getTransport_info());
        return result;
    }


    @Override
    public int totalTransport() throws SQLException {
        String sql="select count(transport_id) from transport";
        int result=0;
        try{
            res=queryDB(sql);
            result=res.getInt(1);
        }finally {
            closeALL(conn,stat,res);
        }
        return result;
    }

    @Override
    public int updateTransport(Transport transport) throws SQLException {
        int result=0;
        String sql="update transport set start_date=?,end_date=?,pay_type=?,transport_fee=?,insurance_fee=?,transport_start=?,transport_distinatin=?,transport_info=? where transport_id=?";
        result=updateDB(sql,transport.getStart_date(),transport.getEnd_date(),transport.getPay_type(),transport.getTransport_fee(),transport.getInsurance_fee(),transport.getTransport_start(),transport.getTransport_distinatin(),transport.getTransport_info(),transport.getTransport_id());
        return result;
    }
}
