package com.lanou.spring.dao;

import com.lanou.spring.bean.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Setter
@Getter
public class UserDaoImple implements UserDao {
    private Connection connection;
    @Override
    public int updataUser(User user) throws SQLException {
        String sql = "update library set last_login_time = ? where id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setTimestamp(1, user.getLast_login_time());
        pstmt.setInt(2, user.getId());
        return pstmt.executeUpdate();
    }

    @Override
    public void setConnection(Connection conn) {

    }


}
