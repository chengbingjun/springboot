package com.srpingBootTest.ExecturConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author cbjun
 * @create 2020/10/20 15:56
 */
@Configuration
public class ExecturConfig {

    @Bean("mvcTaskExecutor")
    public ThreadPoolTaskExecutor mvcTaskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        int i = Runtime.getRuntime().availableProcessors();//获取到服务器的cpu内核（会不太准确）
//        executor.setCorePoolSize(i*2);//核心池大小
        executor.setCorePoolSize(5);//核心池大小
        executor.setMaxPoolSize(100);//最大线程数
        executor.setQueueCapacity(1000);//队列程度
        executor.setKeepAliveSeconds(1000);//线程空闲时间
        executor.setThreadNamePrefix("tsak-asyn");//线程前缀名称
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//配置拒绝策略
        return executor;
    }

}
