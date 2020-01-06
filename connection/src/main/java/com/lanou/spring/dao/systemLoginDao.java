package com.lanou.spring.dao;

import com.lanou.spring.bean.SystemLog;

import java.sql.Connection;
import java.sql.SQLException;

public interface systemLoginDao {
   int insetLog(SystemLog systemLog) throws SQLException;;
   void setConnection(Connection conn);
}
