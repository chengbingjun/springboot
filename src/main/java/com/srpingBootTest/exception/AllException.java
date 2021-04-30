package com.srpingBootTest.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cbjun
 * @create 2020/7/29 11:40
 */
//全局异常捕捉
@ControllerAdvice
public class AllException {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map exceptionHandler(Exception e) {
        Map map = new HashMap();
        map.put("-1",e.getMessage());
        System.out.println("------------------->"+"hahahahha");
        return map;
    }
}
