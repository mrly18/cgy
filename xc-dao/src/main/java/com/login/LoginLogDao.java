package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2016/4/11.
 */
@Repository
public class LoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sql="insert into t_login_log values(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{null,loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()});
    }

}
