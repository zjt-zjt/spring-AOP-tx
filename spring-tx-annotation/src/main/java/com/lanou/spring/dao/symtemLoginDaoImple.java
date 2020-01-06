package com.lanou.spring.dao;

import com.lanou.spring.bean.SystemLog;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Setter
@Getter
public class symtemLoginDaoImple implements  systemLoginDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insetLog(SystemLog systemLog) {
        String sql = "insert into  systemlogin (operator,action,createTime) values(?,?,?)";
        return jdbcTemplate.update(sql,new Object[]{systemLog.getOperator(),systemLog.getAction(),systemLog.getCreateTime()});
    }
}
