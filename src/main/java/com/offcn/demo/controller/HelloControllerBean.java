package com.offcn.demo.controller;

import com.offcn.demo.bean.UserBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({UserBody.class})
public class HelloControllerBean {
    @Autowired
    UserBody userBody;

    @GetMapping("/getUser")
    public String getUser(){
        return userBody.toString();
    }

}
