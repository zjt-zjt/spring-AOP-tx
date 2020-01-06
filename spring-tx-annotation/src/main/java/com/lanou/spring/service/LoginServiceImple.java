package com.lanou.spring.service;

import com.lanou.spring.bean.SystemLog;
import com.lanou.spring.bean.User;
import com.lanou.spring.dao.UserDao;
import com.lanou.spring.dao.systemLoginDao;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Service
public class LoginServiceImple implements  LoginService {
     @Autowired
    private UserDao userDao;
     @Autowired
    private systemLoginDao system;
    @Override

    @Transactional(rollbackFor = Exception.class)
    public void login(User user) {

        user.setLast_login_time(new Timestamp(System.currentTimeMillis()));
        userDao.updataUser(user);
        int c= 9/0;
        SystemLog sl = new SystemLog();
        sl.setOperator(user.getUsername());
        sl.setAction("日志");
        sl.setCreateTime(new Date());
         system.insetLog(sl);


    }
}
