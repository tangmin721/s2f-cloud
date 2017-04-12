package com.gasq.cloud.consumer.user.feign;

import com.gasq.cloud.common.result.Result;
import com.gasq.cloud.consumer.user.entity.User;
import com.gasq.cloud.consumer.user.feign.fallback.UserFeignClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserFeignClient.java
 * @Package com.gasq.cloud.consumer.user.feign
 * @Description: UserFeignClient（服务名）
 * @date 2017-04-12 12:46:18
 */
@FeignClient(name = "s2f-cloud-provider-user",
    //fallback = UserFeignClientFallback.class,
    fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    /**
     * 1、不支持GetMapping等复合注解
     * 2、PathVariable后要定名称
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    Result getUserById(@PathVariable("id") Long id);

    @RequestMapping(value = "/user/saveUser",method = RequestMethod.POST)
    Result saveUser(@RequestParam(value = "name",required = false) String name,
                    @RequestParam(value = "age",required = false)  Integer age,
                    @RequestParam(value = "remark",required = false) String remark);

    /**
     * 不支持复杂对象？@todo
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/saveUser",method = RequestMethod.POST)
    Result saveUserEntity(User user);
}
