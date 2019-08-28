package com.dao.impl;

import com.dao.UserDao;
import com.entity.User;
import com.util.DButil;

import java.sql.SQLException;

public class UserDaoImpl extends DButil implements UserDao {
    @Override
    public User logIn(String name, String passwd) throws SQLException {
        String sql="select * from user where user_name=? and user_password=?";
        User user=null;
        try{
            res=queryDB(sql,name,passwd);
            if(res.next()){
                user=new User();
                user.setUser_id(res.getInt("user_id"));

                user.setUser_name(res.getString("user_name"));

                user.setUser_name(res.getString(" user_name"));

            }
        }finally {
            closeALL(conn,stat,res);
        }

        return user;
    }
}
