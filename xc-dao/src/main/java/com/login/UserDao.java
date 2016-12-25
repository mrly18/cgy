package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lenovo on 2016/4/10.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName,String password){
        String sql="SELECT count(1) FROM t_user WHERE user_name=? and password=?";
        return jdbcTemplate.queryForInt(sql,new Object[]{userName,password});
    }

    public User findUserByUserName(final String userName){
        String sql="SELECT user_id,user_name,credits FROM t_user where user_name=?";
        final User user=new User();
        jdbcTemplate.query(sql, new Object[]{userName}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(rs.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user){
        String sql="update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";
        jdbcTemplate.update(sql,new Object[]{user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
