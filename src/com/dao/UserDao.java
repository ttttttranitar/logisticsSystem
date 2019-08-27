package com.dao;

import com.entity.User;

import java.sql.SQLException;

public interface UserDao {
    public User logIn(String name, String passwd )throws SQLException;
}
