package com.lanou.spring.service;

import com.lanou.spring.bean.User;

import java.sql.SQLException;

public interface LoginService {
    void login(User user) throws SQLException;
}
