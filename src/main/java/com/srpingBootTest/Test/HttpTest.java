package com.srpingBootTest.Test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author cbjun
 * @create 2020/7/1 11:26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HttpTest {
    @Resource
    private RestTemplate restTemplate;

    @Test
    public void test04() {
        //网上教程地址：https://www.cnblogs.com/javazhiyin/p/9851775.html
        String url = "http://localhost:8201/platform/frozenAccount";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("acct_no", "3320005400000002");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(url,request,Map.class);
        System.out.println(response.getBody());
    }
}
