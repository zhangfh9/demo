package com.offcn.demo.service.impl;

import com.offcn.demo.bean.User;
import com.offcn.demo.service.Uservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements Uservice {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<User> getUserList() {
        return jdbcTemplate.query("select * from user",new BeanPropertyRowMapper<>(User.class));

    }

    @Override
    public void createUser(User user) {
        jdbcTemplate.update("insert into user(name ,age)values (?,?)",user.getName(),user.getAge());
    }

    @Override
    public User getUser(Long id) {
        return jdbcTemplate.queryForObject("select * from user where id=?",new BeanPropertyRowMapper<>(User.class),id);

    }

    @Override
    public void updateUser(Long id, User user) {
        jdbcTemplate.update("update user set name=?,age=? where id=?",user.getName(),user.getAge(),id);
    }

    @Override
    public void deleteUser(Long id) {
        jdbcTemplate.update("delete from user where id=?",id);
    }
}
