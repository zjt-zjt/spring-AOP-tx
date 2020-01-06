package com.lanou.spring;

import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Getter
@Setter
public class ConnectionHodler {
    private DataSource dataSource;

    private Connection conn = null;

    public Connection getConnection() {
        if(conn == null) {
            try {
                conn = dataSource.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
