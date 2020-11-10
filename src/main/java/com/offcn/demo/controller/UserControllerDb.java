package com.offcn.demo.controller;

import com.offcn.demo.bean.User;
import com.offcn.demo.service.Uservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerDb {

    @Autowired
    Uservice uservice;

    @GetMapping("/")
    public List<User> getUserList(){
        return uservice.getUserList();
    }

    /***
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/")
    public String createUser(User user) {
        uservice.createUser(user);
        return "success";
    }

    /***
     * 获取指定id用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id")Long id) {

        return uservice.getUser(id);
    }
    /**
     * 更新指定id用户信息
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id,User user) {
        uservice.updateUser(id, user);
        return "success";
    }

    /***
     * 删除指定id用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        uservice.deleteUser(id);
        return "success";

    }

}
