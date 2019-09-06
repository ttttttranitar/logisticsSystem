package com.dao.impl;

import com.dao.TransportContractDao;
import com.entity.TransportContract;
import com.util.DButil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportContractDaoImpl extends DButil implements TransportContractDao {
    @Override
    public int add(TransportContract contract) throws SQLException {
        String sql="insert into transport_contract value(?,?,?,?,?)";
        int result=updateDB(sql,contract.getTransport_id(),contract.getDriver_id(),contract.getStart_date(),contract.getEnd_date(),contract.getTotal_fee());
        return result;
    }

    @Override
    public TransportContract getContract(String transportId,String driverId) throws SQLException {
        String sql="select * from transport_contract where transport_id=? and driver_id=?";
        try{
           TransportContract contract=null;
           res=queryDB(sql,transportId,driverId);
           if(res.next()){
               contract=new TransportContract();
               contract.setTransport_id(res.getString("transport_id"));
               contract.setDriver_id(res.getString("driver_id"));
               contract.setStart_date(res.getString("start_date"));
               contract.setEnd_date(res.getString("end_date"));
               contract.setTotal_fee(res.getDouble("total_fee"));
           }
           return contract;
        }finally {
            closeALL(conn,stat,res);
        }
    }

    @Override
    public List<TransportContract> getContractList(int currentPage,int pageSize) throws SQLException {
        String sql="select * from transport_contract limit ?,?";
        List<TransportContract> contractList =new ArrayList<TransportContract>();
        try{
            TransportContract contract=null;
            res=queryDB(sql,(currentPage-1)*pageSize,pageSize);
            while(res.next()){
                contract=new TransportContract();
                contract.setTransport_id(res.getString("transport_id"));
                contract.setDriver_id(res.getString("driver_id"));
                contract.setStart_date(res.getString("start_date"));
                contract.setEnd_date(res.getString("end_date"));
                contract.setTotal_fee(res.getDouble("total_fee"));
                contractList.add(contract);
            }
            return contractList;
        }finally {
              closeALL(conn,stat,res);
        }
    }

    @Override
    public int del(String transportId,String driverId) throws SQLException {
        String sql="delete from transport_contract where transport_id=? and driver_id=?";
        int result=updateDB(sql,transportId,driverId);
        return result;
    }

    @Override
    public int totalContract() throws SQLException {
        String sql="select count(transport_id) from transport_contract";
        try{
            res=queryDB(sql);
            int result=0;
            if(res.next()){
                result=res.getInt(1);
            }
            return result;
        }finally {
            closeALL(conn,stat,res);
        }

    }
}
