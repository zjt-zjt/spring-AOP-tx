package com.lanou.spring.service;

import com.lanou.spring.ConnectionHodler;
import com.lanou.spring.bean.SystemLog;
import com.lanou.spring.bean.User;
import com.lanou.spring.dao.UserDao;
import com.lanou.spring.dao.systemLoginDao;

import lombok.Getter;
import lombok.Setter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class LoginServiceImple implements  LoginService {

    private UserDao userDao;
    private systemLoginDao system;

    private ConnectionHodler connectionHodler;
    @Override
    public void login(User user)throws SQLException {

        Connection conn = null;
        try {
            conn = connectionHodler.getConnection();
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            // 2. 业务操作
            // 2.1 更新用户表用户最后登录时间
            userDao.setConnection(conn);
            user.setLast_login_time(new Timestamp(System.currentTimeMillis()));
            userDao.updataUser(user);

           // int ret = 9 / 0;  // 模拟操作异常

            // 2.2 插入登录日志
            SystemLog log = new SystemLog();
            log.setAction("login");
            log.setOperator(user.getUsername());
            log.setCreateTime(new Date());
            system.setConnection(conn);
            system.insetLog(log);
            if(conn != null) {
                conn.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 3. 出现异常回滚，没异常就提交




    }
}
