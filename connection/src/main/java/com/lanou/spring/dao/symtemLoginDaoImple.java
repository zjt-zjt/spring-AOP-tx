package com.lanou.spring.dao;

import com.lanou.spring.bean.SystemLog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

@Setter
@Getter
public class symtemLoginDaoImple implements  systemLoginDao {
    private Connection connection;
    @Override
    public int insetLog(SystemLog systemLog) throws SQLException {
        String sql = "insert into  systemlogin (operator,action,createTime) values(?,?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, systemLog.getAction());
        pstmt.setString(2, systemLog.getOperator());
        pstmt.setString(3, sdf.format(systemLog.getCreateTime()));
        return pstmt.executeUpdate();
    }

    @Override
    public void setConnection(Connection conn) {

    }
}
