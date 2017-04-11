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

    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable Long id){
        Result forObject = restTemplate.getForObject("http://localhost:8080/user-provider/user/" + id, Result.class);
        return forObject;
    }

}
