package com.dao.impl;

import com.dao.ClientDao;
import com.entity.Client;
import com.util.DButil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl extends DButil implements ClientDao {
    @Override
    public int save(Client client) throws SQLException {
        String sql = "INSERT INTO `custom`(`custom_id`,`custom_name`,`fax`,`phone`,`mail`,`addr`,`email`,`contact`,`contact_phone`,`client_type`,`company_type`,`company_scale`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        return updateDB(sql,client.getCustomer_id(),client.getCustomer_name(),client.getFaxed(),client.getPhone(),client.getPostcode(),client.getSite(),client.getEmail(),client.getContacts(),client.getContact_phone(),client.getClient_type(),client.getEnterprise_property(),client.getEnterprise_scale());
    }

    @Override
    public int update(Client client) throws SQLException {
        String sql = "UPDATE `custom` SET `custom_id`=?,`custom_name`=?,`fax`=?,`phone`=?,`mail`=?,`addr`=?,`email`=?,`contact`=?,`contact_phone`=?,`client_type`=?,`company_type`=?,`company_scale`=? WHERE `custom_id`=?";
        return updateDB(sql,client.getCustomer_id(),client.getCustomer_name(),client.getFaxed(),client.getPhone(),client.getPostcode(),client.getSite(),client.getEmail(),client.getContacts(),client.getContact_phone(),client.getClient_type(),client.getEnterprise_property(),client.getEnterprise_scale(),client.getCustomer_id());
    }

    @Override
    public Client getClientByID(String customer_id) throws SQLException {
        String sql = "SELECT `custom_id`,`custom_name`,`fax`,`phone`,`mail`,`addr`,`email`,`contact`,`contact_phone`,`client_type`,`company_type`,`company_scale` FROM custom WHERE custom_id=?";
        Client client=null;
        try {
            res =  queryDB(sql,customer_id);
            if (res.next()){
                client=new Client();
                client.setCustomer_id(res.getString("custom_id"));
                client.setCustomer_name(res.getString("custom_name"));
                client.setFaxed(res.getString("fax"));
                client.setPhone(res.getString("phone"));
                client.setPostcode(res.getString("mail"));
                client.setSite(res.getString("addr"));
                client.setEmail(res.getString("email"));
                client.setContacts(res.getString("contact"));
                client.setContact_phone(res.getString("contact_phone"));
                client.setClient_type(res.getString("client_type"));
                client.setEnterprise_property(res.getString("company_type"));
                client.setEnterprise_scale(res.getString("company_scale"));
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return client;
    }

    @Override
    public List<Client> getClientList(int currentPage, int pageSize) throws SQLException {
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT `custom_id`,`custom_name`,`fax`,`phone`,`mail`,`addr`,`email`,`contact`,`contact_phone`,`client_type`," +
                "`company_type`,`company_scale` FROM custom limit ?,?";
        Client client=null;
        try {
            res =  queryDB(sql,(currentPage-1)*pageSize,pageSize);
            while(res.next()){
                client=new Client();
                client.setCustomer_id(res.getString("custom_id"));
                client.setCustomer_name(res.getString("custom_name"));
                client.setFaxed(res.getString("fax"));
                client.setPhone(res.getString("phone"));
                client.setPostcode(res.getString("mail"));
                client.setSite(res.getString("addr"));
                client.setEmail(res.getString("email"));
                client.setContacts(res.getString("contact"));
                client.setContact_phone(res.getString("contact_phone"));
                client.setClient_type(res.getString("client_type"));
                client.setEnterprise_property(res.getString("company_type"));
                client.setEnterprise_scale(res.getString("company_scale"));
                clientList.add(client);
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return clientList;
    }

    @Override
    public int getClientCount() throws SQLException {
        int count = 0;
        String sql = "select count(custom_id) from custom";
        try {
            res=queryDB(sql,null);
            if (res.next()){
                count =  res.getInt(1);
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return count;
    }


}
