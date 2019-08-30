package com.service;

import com.entity.Transport;

import java.sql.SQLException;
import java.util.List;

public interface TransportService {
    public Transport getTransport(String transportId);
    public List<Transport> getTransportList(int curretPage, int pageSize);
    public int addTransport(Transport transport,String orderId);
    public String idGenerator(String orderId);
    public  int totalTransport();
}
