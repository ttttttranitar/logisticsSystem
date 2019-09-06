package com.service;

import com.entity.TransportContract;

import java.util.List;

public interface TransportContractService {
    public int add(TransportContract contract);
    public TransportContract getContract(String transportId,String driverId);
    public List<TransportContract> getContractList(int currentPage, int pageSize);
    public int del(String transportId,String driverId);
}
