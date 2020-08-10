package com.srpingBootTest.controller;

import com.srpingBootTest.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpringBoot {

    @Autowired
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        helloService.hello();
        return "hello springBoot";
    }
}
