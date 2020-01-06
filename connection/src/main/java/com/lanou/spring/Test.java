package com.lanou.spring;

import com.lanou.spring.bean.User;
import com.lanou.spring.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        LoginService loginService = ctx.getBean(LoginService.class);

        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        try {
            loginService.login(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
