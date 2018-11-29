package com.layman.controller;

import com.layman.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试使用的Controller
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
   //private TestService testService;

    @ResponseBody
    @RequestMapping("/queryNow")
    public String queryNow(){

        // 1.引入服务
        // 2.注入服务
        // 3.调用服务方法
        System.out.println("queryNow is coming");
        return "/index";
//        return testService.queryNow();
   }
}
