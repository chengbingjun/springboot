package com.srpingBootTest.service;


import com.srpingBootTest.Utils.soap.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//天气相关webservice调用

/**
 * 1.生成wsdl文件（可以用远程url，也可以用本地wsdl文件）
 * 2.通过wsimport命令生成webService客户端代码实例
 * 3.调用
 * 例子：https://blog.csdn.net/weixin_30338481/article/details/98324138?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.edu_weight&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.edu_weight
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherWebservice {

    @Test
    public void getWeather() {
        //创建一个WeatherWS工厂
        WeatherWebService weatherWebService = new WeatherWebService();
        //根据工厂创建一个WeatherWSSoap对象
        WeatherWebServiceSoap weatherWSSoap = weatherWebService.getWeatherWebServiceSoap();
        //调用WebService提供的getWeather方法获取南宁市的天气预报情况
        ArrayOfString weatherInfo = weatherWSSoap.getWeatherbyCityName("杭州");
        List<String> lstWeatherInfo = weatherInfo.getString();
        //遍历天气预报信息
        for (String string : lstWeatherInfo) {
            System.out.println(string);
            System.out.println("------------------------");
        }
        //获得中国省份、直辖市、地区和与之对应的ID
        ArrayOfString s = weatherWSSoap.getSupportProvince();
        List<String> list = s.getString();
        for (String string : list) {
            System.out.println(string);
            System.out.println("------------------------");
        }
    }

    @Test
    public void getPhoneAddr() {
        //创建一个MobileCodeWS工厂
        MobileCodeWS factory = new MobileCodeWS();
        //根据工厂创建一个MobileCodeWSSoap对象
        MobileCodeWSSoap mobileCodeWSSoap = factory.getMobileCodeWSSoap();
        //调用WebService提供的getMobileCodeInfo方法查询手机号码的归属地
        String searchResult = mobileCodeWSSoap.getMobileCodeInfo("18512155752", null);
        System.out.println(searchResult);
    }

}
