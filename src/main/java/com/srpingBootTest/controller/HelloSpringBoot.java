package com.srpingBootTest.controller;

import com.srpingBootTest.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class HelloSpringBoot {

    @Autowired
    private HelloService helloService;

    @Autowired
    @Qualifier("mvcTaskExecutor")
    private ThreadPoolTaskExecutor mvcTaskExecutor;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        helloService.hello();
        return "hello springBoot";
    }

    @GetMapping("/refundCash")
    public SseEmitter CashWindows() {
        //默认超时时间30秒，0为永不超时
        final SseEmitter sseEmitter = new SseEmitter(0L);
        //这里的SseEmitter的send不能阻塞主线程，必须提前返回，需要把send放到异步里头
        mvcTaskExecutor.execute(() -> {
            try {
                for(int i = 0;i<10;i++){
                    sseEmitter.send(i);
                    Thread.sleep(1000);
                }
                sseEmitter.complete();
            } catch (Exception e) {
                sseEmitter.completeWithError(e);
            }
        });
        return sseEmitter;
    }

    //消息推送的详细学习：https://blog.csdn.net/wiselyman/article/details/84916873
    //本实例地址：https://my.oschina.net/go4it/blog/1609751
}
