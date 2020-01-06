package com.lanou.spring.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SystemLog {

    private Integer id;
    private String operator;
    private String action;
    private Date createTime;


}
