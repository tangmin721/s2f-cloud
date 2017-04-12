package com.gasq.cloud.consumer.user.controller;

import com.gasq.cloud.common.result.Result;
import com.gasq.cloud.common.result.ResultUtil;
import com.gasq.cloud.consumer.user.entity.User;
import com.gasq.cloud.consumer.user.feign.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * restTemplate集成了ribbon功能，url里相当于一个vip
     * @HystrixCommand 熔断器指定方法名
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    //@HystrixCommand(fallbackMethod = "getUserFallback")  与fallback在隔离的线程，下面定义commandProperties的方式是在同一个线程里执行
    @HystrixCommand(fallbackMethod = "getUserFallback", commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public Result getUser(@PathVariable Long id){
        Result forObject = restTemplate.getForObject("http://s2f-cloud-provider-user/user/" + id, Result.class);
        return forObject;
    }

    /**
     * 注意，方法参数要一致
     * @param id
     * @return
     */
    public Result getUserFallback(Long id){
        return ResultUtil.FAIL("fall back");
    }
    /**
     * 调用第二种方式，利用FeignClient调用（推荐）
     * @param id
     * @return
     */
    @GetMapping("/getFeignUser/{id}")
    public Result getFeignUser(@PathVariable Long id){
        return userFeignClient.getUserById(id);
    }

    @PostMapping("/saveFeignUser")
    public Result saveFeignUser(User user){
        return userFeignClient.saveUser(user.getName(),user.getAge());
    }

    /**
     * 不支持复杂对象
     * @param user
     * @return
     */
    @PostMapping("/saveFeignUserEntity")
    public Result saveFeignUserEntity(User user){
        System.out.println("-->saveFeignUserEntity");
        return userFeignClient.saveUserEntity(user);
    }

}
