package com.gasq.cloud.consumer.user.feign.fallback;

import com.gasq.cloud.common.result.Result;
import com.gasq.cloud.common.result.ResultUtil;
import com.gasq.cloud.consumer.user.entity.User;
import com.gasq.cloud.consumer.user.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserFeignClientHystrixFallback.java
 * @Package com.gasq.cloud.consumer.user.feign.fallback
 * @Description: 为UserFeignClient增加fallback方法
 * @date 2017-04-12 16:39:02
 */
@Component
public class UserFeignClientHystrixFallback implements UserFeignClient{
    @Override
    public Result getUserById(Long id) {
        return ResultUtil.FAIL("getUserById fall back");
    }

    @Override
    public Result saveUser(String name, Integer age) {
        return ResultUtil.FAIL("saveUser fall back");
    }

    @Override
    public Result saveUserEntity(User user) {
        return ResultUtil.FAIL("saveUserEntity fall back");
    }
}
