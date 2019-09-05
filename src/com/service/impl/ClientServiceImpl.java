package com.service.impl;

import com.dao.ClientDao;
import com.dao.impl.ClientDaoImpl;
import com.entity.Client;
import com.service.ClientService;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class ClientServiceImpl implements ClientService {

    @Override
    public int save(Client client) {
        try {
            client.setCustomer_id(IDgenerator());
            return new ClientDaoImpl().save(client);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Client client) {
        try {
            return new ClientDaoImpl().update(client);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int del(String customer_id) {
        try {
            return new ClientDaoImpl().del(customer_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //查找编号是否存在
    @Override
    public boolean isExist(String customer_id) {
        ClientDao clientDao = new ClientDaoImpl();
        Client client = null;
        try {
            client = clientDao.getClientByID(customer_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (client!=null){
            return true;
        }
        return false;
    }

    @Override
    public Client getClientByID(String customer_id) {
        try {
            return new ClientDaoImpl().getClientByID(customer_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public String IDgenerator() {
        Random random = new Random();
        Boolean isExists = false;
        String customerID = "";
        do {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<6;i++) {
                sb.append(random.nextInt(10));
            }
            customerID = "KH"+sb;
            if (isExist(customerID)){
                isExists=true;
            }
        }while (isExists);
        return customerID;
    }

    @Override
    public List<Client> getClientList(int currentPage,int pageSize) {
        try {
            return new  ClientDaoImpl().getClientList(currentPage,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public int getClientCount() {
        try {
            return new ClientDaoImpl().getClientCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
