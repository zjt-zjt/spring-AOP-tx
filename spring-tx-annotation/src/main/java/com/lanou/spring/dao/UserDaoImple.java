package com.lanou.spring.dao;

import com.lanou.spring.bean.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Setter
@Getter
public class UserDaoImple implements UserDao {
@Autowired
private JdbcTemplate jdbcTemplate;
    @Override
    public int updataUser(User user) {
        String sql = "update library set last_login_time = ? where id = ?";
        return jdbcTemplate.update(sql,new Object[]{ user.getLast_login_time(),user.getId()});
    }


}
