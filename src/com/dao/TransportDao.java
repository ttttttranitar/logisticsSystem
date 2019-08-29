package com.dao;

import com.entity.Transport;

import java.sql.SQLException;
import java.util.List;

public interface TransportDao {
    public Transport getTransport(String transportId) throws SQLException;
    public List<Transport> getTransportList(int currentPage, int pageSize) throws SQLException;
    public int addTransport(Transport transport) throws SQLException;
    public int totalTransport() throws SQLException;
}
