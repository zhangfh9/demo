package com.offcn.demo.controller;

import com.offcn.demo.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@RestController
@RequestMapping("/user")
public class UserController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public List<User> getUserList(){
        return userList;
    }

    @PostMapping("/")
    public String add(@RequestBody User user) {
        userList.add(user);
        return "success";
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id")Long id){
        for (User user : userList) {
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id,@RequestBody User user) {
        for (User user2 : userList) {
            if(user2.getId()==id) {
                user2.setName(user.getName());
                user2.setAge(user.getAge());
            }
        }
        return "success";
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        userList.remove(findOne(id));
        return "success";
    }



}
