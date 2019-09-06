package com.service.impl;

import com.dao.impl.TransportContractDaoImpl;
import com.entity.TransportContract;

import java.sql.SQLException;
import java.util.List;

public class TransportContractServiceImpl implements com.service.TransportContractService {
    @Override
    public int add(TransportContract contract) {
        try {
            return new TransportContractDaoImpl().add(contract);

        }catch(SQLException e){
            System.err.println("数据库错误");
            return -1;
        }
    }

    @Override
    public TransportContract getContract(String transportId, String driverId) {
        try{
            return new TransportContractDaoImpl().getContract(transportId,driverId);
        }catch(SQLException e){
            System.err.println("数据库错误");
            return null;
        }
    }

    @Override
    public List<TransportContract> getContractList(int currentPage, int pageSize) {
        try{
            return new TransportContractDaoImpl().getContractList(currentPage,pageSize);
        }catch(SQLException e){
            System.err.println("数据库错误");
            return null;
        }
    }

    @Override
    public int del(String transportId, String driverId) {
        try{
            return new TransportContractDaoImpl().del(transportId, driverId);
        }catch (SQLException e){
            System.err.println("数据库错误");
            return -1;
        }
    }
}
