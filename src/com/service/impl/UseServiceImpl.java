package com.service.impl;

import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;

import java.sql.SQLException;

public class UseServiceImpl implements UserService {
    @Override
    public User logIn(String name, String passwd) {
        try {
            return new UserDaoImpl().logIn(name, passwd);
        } catch (SQLException e) {
            System.err.println("���ݿ����");
            e.printStackTrace();
            return  null;
        }


    }
}
