package com.dao;

import com.entity.TransportContract;

import java.sql.SQLException;
import java.util.List;

public interface TransportContractDao {
    int add(TransportContract contract) throws SQLException;
    TransportContract getContract(String transportId,String driverId) throws SQLException;
    List<TransportContract> getContractList(int currentPage,int pageSize) throws SQLException;
    int del(String transportId,String driverId) throws SQLException;
    public int totalContract() throws SQLException;
}
