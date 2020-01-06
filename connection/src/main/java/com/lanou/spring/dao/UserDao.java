package com.lanou.spring.dao;

import com.lanou.spring.bean.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao  {
   int  updataUser(User user) throws SQLException;
   void setConnection(Connection conn);

}
