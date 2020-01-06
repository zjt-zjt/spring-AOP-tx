package com.lanou.spring.bean;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Setter
@Getter
public class User {

    private Integer id;
    private String username;
    private Timestamp last_login_time;

}
