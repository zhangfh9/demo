package com.offcn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebJarsDemoController {
    @GetMapping("/")
    public String index(){
        return "hellowebjars.html";
    }
}
