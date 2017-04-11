package com.gasq.cloud.consumer.user.controller;

import com.gasq.cloud.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserConsumerController.java
 * @Package com.gasq.cloud.consumer.user.controller
 * @Description: 
 * @date 2017-04-11 22:55:06
 */
@RestController
public class UserConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * restTemplate集成了ribbon功能，url里相当于一个vip
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable Long id){
        Result forObject = restTemplate.getForObject("http://s2f-cloud-provider-user/user-provider/user/" + id, Result.class);
        return forObject;
    }

}
