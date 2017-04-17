package com.gasq.cloud.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangmin
 * @version V1.0
 * @Title: TestController.java
 * @Package com.gasq.cloud.user.controller
 * @Description:  测试cloud config
 * @date 2017-04-17 10:36:46
 */
@RestController
@RefreshScope
@RequestMapping("/test")
public class TestController {

    @Value("${myprofile}")
    private String myprofile;

    @Value("${profile}")
    private String profile;

    @GetMapping("profile")
    public String getProfile(){
        return "profile:"+profile+",myprofile:"+myprofile;
    }
}
