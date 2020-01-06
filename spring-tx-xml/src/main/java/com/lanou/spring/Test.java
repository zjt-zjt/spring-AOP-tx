package com.lanou.spring;

import com.lanou.spring.bean.User;
import com.lanou.spring.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
         tx();

    }

   public  static void tx(){

       ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
         LoginService  login = ctx.getBean(LoginService.class);
           User user = new User();
           user.setId(1);
           user.setUsername("张三");
           login.login(user);

   }

}
