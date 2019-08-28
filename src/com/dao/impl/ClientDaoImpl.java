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
        String sql = "INSERT INTO `custom`(`custom_id`,`custom_name`,`fax`,`phone`,`mail`,`addr`,`email`,`contact`,`client_type`,`company_type`,`company_scale`)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        return updateDB(sql,client.getCustomer_id(),client.getCustomer_name(),client.getFaxed(),client.getPhone(),client.getPostcode(),client.getSite(),client.getEmail(),client.getContacts(),client.getClient_type(),client.getEnterprise_property(),client.getEnterprise_scale());
    }

    @Override
    public Client getClientByID(String customer_id) throws SQLException {
        String sql = "SELECT `custom_id`,`custom_name`,`fax`,`phone`,`mail`,`addr`,`email`,`contact`,`client_type`,`company_type`,`company_scale` FROM custom WHERE custom_id=?";
        Client client=null;
        try {
            res =  queryDB(sql,customer_id);
            if (res.next()){
                client.setCustomer_id(res.getString("custom_id"));
                client.setCustomer_name(res.getString("custom_name"));
                client.setFaxed(res.getString("fax"));
                client.setPhone(res.getString("phone"));
                client.setPostcode(res.getString("mail"));
                client.setSite(res.getString("addr"));
                client.setEmail(res.getString("email"));
                client.setContacts(res.getString("contact"));
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
    public List<Client> getUserListPage() throws SQLException {
        List<Client> clientList = new ArrayList<>();
        String sql = "SELECT `custom_id`,`custom_name`,`fax`,`phone`,`mail`,`addr`,`email`,`contact`,`client_type`," +
                "`company_type`,`company_scale` FROM custom";
        Client client=null;
        try {
            res =  queryDB(sql);
            if (res.next()){
                client.setCustomer_id(res.getString("custom_id"));
                client.setCustomer_name(res.getString("custom_name"));
                client.setFaxed(res.getString("fax"));
                client.setPhone(res.getString("phone"));
                client.setPostcode(res.getString("mail"));
                client.setSite(res.getString("addr"));
                client.setEmail(res.getString("email"));
                client.setContacts(res.getString("contact"));
                client.setClient_type(res.getString("client_type"));
                client.setEnterprise_property(res.getString("company_type"));
                client.setEnterprise_scale(res.getString("company_scale"));
            }
        } finally {
            closeALL(conn,stat,res);
        }
        return clientList;
    }
}
