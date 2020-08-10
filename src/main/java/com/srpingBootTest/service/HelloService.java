package com.srpingBootTest.service;

import org.springframework.stereotype.Service;

/**
 * @Author cbjun
 * @create 2020/7/29 13:21
 */
@Service
public class HelloService {

    public String hello(){
        int a = 1/0;
        return "hello";
    }
}
